class Db {
    private static Map<Integer, Connection> map;

    public static Connection getConnection( int sessionId ){

        if( !map.containsKey( sessionId ) ) {
            map.put( sessionId, createConnection());
        }
        return map.get( sessionId );
    }
}
class Main {
    void processs() {
        int sessionId = createSesionId();
        ModuleA a = new ModuleA( sessionId );
        a.doAsStuff();
        ModuleB b = new ModuleB( sessionId );
        b.doBsStuff();
        ModuleC c = new ModuleC( sessionId );
        b.doCsStuff();
        a.closeTransaction();

    }
}
class ModuleA{

    public doAsStuff() {
        Connection c = Db.getConnection(sessionId);
        doSomethingWith( c );
    }
    public closeTransaction() {
        Connection c = Db.getConnection(sessionId);
        c.close();
    }
}
class ModuleB{

    public doBsStuff() {
        Connection c = Db.getConnection(sessionId);
        doSomethingWith( c );
    }
}
class ModuleC{

    public doCsStuff() {
        Connection c = Db.getConnection(sessionId);
        doSomethingWith( c );
    }
}