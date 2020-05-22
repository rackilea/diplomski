@Module()
public class MyAppModule {
  @Provides ConnectionDictonary connectionDictionary() {
    return new ConnectionDictonary(System.getProperty("some.property"));
  }

  /** Stateless mockable utilities for this app */
  @Provides Util util() { new Util(); }

  @Provides @Singleton DataStore store() { 
    return new DataStore();
  }

  @Provides @Singleton ConnectionPool pool(DataStore store, ConnectionDictionary dict) { 
    try {
      return DataStore.connectionPool(dict, System.getProperty("pool.size"));
    } catch (Exception e) {
      // bad bad bad
      throw new RuntimeException("Could not connect to datastore.", e);
    }
  }

}

// This module "adds to" MyAppModule by adding additional graph elements in
// an extended graph.
@Module(injects=MyRequestEndpoint.class, addsTo = MyAppModule.class)
public class MyRequestModule {
  private Request req;
  public MyRequestModule(Request req) { this.req = req; }

  @Provides @Singleton RequestObject request() { return req; }

  @Provides @Singleton User user(ConnectionPool pool, Request req, Util util) {
    try {
      Connection conn = pool.obtain();
      // getUser cannot throw null;
      return util.getUser(conn, req.get("user.id"), Crypto.hash(req.get("pass")));
    } catch (UserNotFoundException e) {
      return User.UNKNOWN;
    } catch (Exception e) {
      throw new RuntimeException("Could not obtain a user.", e);
    } finally { 
      // TODO: try-with-resources in Java7
      pool.release();
    }
  }

}

public class MyRequestEndpoint {
  @Inject ConnectionPool pool;
  @Inject Request req;

  public Output performService() {
    try {
      Connection conn = pool.obtain();
      // ... does stuff with request
    } finally {
      conn.release();
    }
  }
}

public class MyApp {    
  public void main(String ... args) {
    graph = ObjectGraph.create(MyAppModule.class);
    new ServiceListener(graph).start(); 
  }
}

public ServiceListener {
  private final ObjectGraph appGraph;
  public ServiceListener(ObjectGraph appGraph) {
    this.appGraph = appGraph;
  }

  //... infrastructure for listening and building request/response objects, etc.

  public void serveRequest(Request req, Response res) {
    // Take the application-scoped graph and create another graph we will 
    // use in this request and throw away.
    ObjectGraph requestGraph = MyApp.graph().plus(new MyRequestModule(req));
    Output output = requestGraph.get(MyRequestEndpoint.class).performService();
    Util.populateResult(output, result);
    result.flush();
  }
}