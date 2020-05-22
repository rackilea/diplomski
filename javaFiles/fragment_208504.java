class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    class Inner {
        void showEnclosingName() {
            System.out.println("Enclosing instance name: " + name);
        }
    }

    void demo() {
        Outer outer = new Outer("Other Outer");
        Inner inner1 = new Inner(); // Implicitly this.new Inner();
        Inner inner2 = outer.new Inner();
        inner1.showEnclosingName(); // Prints Original Outer
        inner2.showEnclosingName(); // Prints Other Outer
    }

    public static void main(String[] args) {
        Outer outer = new Outer("Original Outer");
        outer.demo();
    }
}