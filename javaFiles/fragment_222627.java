public class Outer {
    static String world() {
        return "world!";
    }
    static class Inner {
        static String helloWorld() {
            return "Hello " + Outer.world();
        }
    }   
    public static void main(String args[]) {
        System.out.println(Outer.Inner.helloWorld());
        // prints "Hello world!"
    }
}