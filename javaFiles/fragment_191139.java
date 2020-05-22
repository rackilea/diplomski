public class Test {
    //using plain naive console app
    public static void main(String[] args) {
        MyInterface myInterfaceA = new A();
        testMethod(myInterfaceA);
        MyInterface myInterfaceB = new B();
        testMethod(myInterfaceB);
        //and more...
    }

    public static void testMethod(MyInterface myInterface) {
        myInterface.method();
    }
}