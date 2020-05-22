public class Main {
    public static void main(String[] args) {
        new X().test();
        new Y().test();
    }
}

class X extends Y{

}

class Y implements Z{
    @Override
    public void test() {
        System.out.println("in Y");
    }
}

interface Z {
    public void test();
}