public class Outer {

    public class Inner1 {
    }

    public static class Inner2 {
    }

    public void method(){

        class LocalInner{
        }

        LocalInner yesThisActuallyCompiles = new LocalInner();
    }
}