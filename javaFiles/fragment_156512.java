public class SelfCatch {
    public static void main(String args[]) throws Exception {
        if (args == null) throw new Exception("Hi there!");
        try {
            main(null);
        } catch (Exception e) {
            System.out.println("Caught: " + e);
        }
        System.out.println("Exiting...");
    }
}