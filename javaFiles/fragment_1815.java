interface Testable {

    @Deprecated
    void test1();

    void test2();

}

public class Test005 implements Testable {

    @Override
    public void test1(){
        System.out.println("hello 1");
    }

    @Override
    public void test2(){
        System.out.println("hello 2");
    }

    public static void main(String[] args){
        Test005 tA = new Test005();
        tA.test1(); // no warning
        tA.test2(); // no warning

        Testable tB = new Test005();
        tB.test1(); // deprecation warning
        tB.test2(); // no warning
    }
}