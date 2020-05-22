public class ImplementedClass implements Interfacename {

    @Override
    public void sayhi(String hello) {
        // TODO Auto-generated method stub

    }

    @Override
    public void sayhello() {
        // TODO Auto-generated method stub

    }

    public Interfacename sayhello1() {
        System.out.println("returning new intance of class which is implementing that interface");
        return new ImplementedClass();
    }
}