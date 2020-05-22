class Outer {

    public class Inner {

    }
}

static void test() {
    Outer outer = new Outer();
    Outer.Inner inner = outer.new Inner();
}