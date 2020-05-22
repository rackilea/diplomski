public abstract class GenericDAO<T> {

  ...

  import java.util.Collection;
  import java.util.Optional;
  import org.neo4j.graphdb.GraphDatabaseService;
  import org.neo4j.ogm.cypher.Filter;
  ...

  public T find(Long id) {
    return session.load(getEntityType(), id, DEPTH_ENTITY);
  }

  public T find(String name) {
    final String propertyName = "name";
    Filter filter = new Filter(propertyName, name);

    Collection<T> results = session.loadAll(getEntityType(), filter, DEPTH_ENTITY);

    if( results.size() > 1)
      throw new CustomRuntimesException("Too results found");

    Optional<T> entity = results.stream().findFirst();

    return entity.isPresent() ? entity.get() : null;
 }

 ...

}