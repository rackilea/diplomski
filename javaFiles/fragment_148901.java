public class Outer {

    public class Inner { }

    public static class StaticNested { }

    public void method () {
        // non-static methods can instantiate static and non-static nested classes
        Inner i = new Inner(); // 'this' is the implied enclosing instance
        StaticNested s = new StaticNested();
    }

    public static void staticMethod () {
        Inner i = new Inner(); // <-- ERROR! there's no enclosing instance, so cant do this
        StaticNested s = new StaticNested(); // ok: no enclosing instance needed

        // but we can create an Inner if we have an Outer: 
        Outer o = new Outer();
        Inner oi = o.new Inner(); // ok: 'o' is the enclosing instance
    }

}