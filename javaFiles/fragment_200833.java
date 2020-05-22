public class T {

    public static void main(String[] args) {
        class A extends B {}
        class B {}
        B a = new A();
    }
}

class B {}