public class MainWithStaticCalls {

   ... // Same thing as above

    public static void main(String[] a) {
        // MainWithStaticCalls.nope();
        System.out.println("************");
        MainWithStaticCalls obj = new MainWithStaticCalls();
        NewClass nc = new NewClass();
        nc.callMe();
        System.out.println("Main");
    }

}