public class A {
    public int i = 0; //not changed, because it is not overrided
    public static String s = "";

    public A(int i) {
        System.out.println(i); //1. 0, 3. 42
        s += "x"; //After second run s="xx", because it is static
    }

    public A debug() {
        if (this instanceof B) {
            System.out.println("Spam"); //5, 7. Spam
            s += "s"; //s = "xxs", than "xxss" because it is static
        }
        return this;
    }
}
public class B extends A {
    public int i = 100;
    public static String s = "s";

    public B(int i, String s) {
        super(i);
        this.i += 5; //First run: i=105, Second run: i=47
        this.s = s; //First run: public static String s="", Second run: public static String a.s="foo"
    }

    public static void main(String[] argv) {
        String s = "";
        B b = new B(0, s);
        System.out.println(b.i + " " + b.s); //2. 105
        s += "foo"; //B.s is now foo
        A a = new B(42, s); 
        System.out.println(a.i + " " + a.s); //3. 0 xx
        System.out.println(b.debug().s + " " + b.i + " " + b.s); //1. because of (A)b.s = xxs, 2. b.i = 105, 3. b.s = foo
        System.out.println(a.debug().s + " " + a.i + " " + a.s); //(A)a.s = "xxss",  (A)a.i = 0, (A)a.s = "xxss"
    }
}