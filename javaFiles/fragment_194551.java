public class Main {

    public static void main(String[] args) {
        B base = new A();
        System.out.println(base);
    }
}

class B {

    private static boolean goo = true;

    protected static boolean foo() {
        goo = !goo;
        return goo;
    }

    public String bar = "Base:" + foo();

    @Override
    public String toString() {
        return bar; //print the variable B.bar
    }
}

class A extends B {
    public String bar = "Sub:" + foo();

    @Override
    public String toString() {
        //print the instance B and the variable A.bar
        return super.toString() + "\n" + bar;
    }
}