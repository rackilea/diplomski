class Super {
    void a() { System.out.println("super implementation"); }
    void b() { System.out.println("calling a()..."); a(); }
}


class Sub extends Super {
    void a() { System.out.println("sub implementation"); }
}


public class Main {
    public static void main(String[] args) {
        Sub x = new Sub();
        x.b();
        // Prints:
        //   calling a()...
        //   sub implementation
    }
}