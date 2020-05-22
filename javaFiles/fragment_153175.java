public final class Concrete1 extends Db<JDBC4Connection> {
    public Concrete1(int id) {
        // I'm not sure whether the id is supposed to be the id of the type
        // of Connection. If so you should just pass a specific number
        // e.g. super(1) and get rid of the id parameter.
        super(id);   
    }
    @Override
    public JDBC4Connection connect() {
        JDBC4Connection conn = whateverYouNeedToDoToGetSuchAThingIDontKnowIveNeverHeardOfIt();
        setT(conn);
        return conn; 
    }   
}