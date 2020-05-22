class Super {
    void method1() {
        System.out.println("Super.method1");
    }

    void method2() {
        System.out.println("Super.method2");
    }
}

class Sub extends Super {
    @Override void method1() {
        // No explicit super call
        System.out.println("Sub.method1");
    }

    @Override void method2() {
        super.method2();
        System.out.println("Sub.method2");
    }
}

public class Test {
    public static void main (String[] args) {
        Super x = new Sub();
        x.method1(); // Prints just Sub.method1
        x.method2(); // Prints Super.method2 and Sub.method2
    }    
}