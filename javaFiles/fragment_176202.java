public class Outer {
    public static void foo(Inner inner) {
        try {
            Field this$0 = inner.getClass().getDeclaredField("this$0");
            Outer outer = (Outer) this$0.get(inner);
            System.out.println("The outer class is: " + outer);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public class Inner {
    }

    public void callFoo() {
        // The constructor of Inner must be called in 
        // non-static context, inside Outer.
        foo(new Inner()); 
    }

    public static void main(String[] args) {
        new Outer().callFoo();
    }
}