public class Test1 implements Serializable, Remote {

    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.createRegistry(1099);
        Context ctx = new InitialContext();
        ctx.bind("rmi://localhost/xxx", new Test1());
        Test1 t1 = (Test1) ctx.lookup("rmi://localhost/xxx");
        System.out.println(t1);
    }
}