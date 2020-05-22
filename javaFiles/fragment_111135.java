public class MainWithStaticCalls {

   ... // Same thing as above

    public static void main(String[] a) {
        // MainWithStaticCalls.nope();
        System.out.println("************");
        MainWithStaticCalls obj1 = new MainWithStaticCalls();
        MainWithStaticCalls obj2 = new MainWithStaticCalls();
        NewClass nc = new NewClass();
        nc.callMe();
        System.out.println("Main");
    }

}