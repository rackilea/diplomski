public class A{
    static{System.out.println("sA");}
    {System.out.println("A1");}

    public Main() {
        System.out.println("new A");
    }

    {System.out.println("A2");}


    public static void main(String[] args) {
        new A();
    }
}

class B extends Main {
    static{System.out.println("sB");}
    { System.out.println("B1"); }

    public B() {
        System.out.println("new B");
    }

    { System.out.println("B2"); }
}