public class MainWithStaticCalls {

    {
        System.out.println("Init block called");
    }

    static {
        String[] str = {"1", "2"};
        System.out.println("Static called");
    }

    public MainWithStaticCalls() {
        System.out.println("this is constructor");
    }

    void MainWithStaticCalls() {
        System.out.println("this is NOT constructor");
    }

    public static void nope() {
        System.out.println("Nope");
    }

    public static void main(String[] a) {
        MainWithStaticCalls.nope();
        System.out.println("************");
        MainWithStaticCalls obj = new MainWithStaticCalls();
        NewClass nc = new NewClass();
        nc.callMe();
        System.out.println("Main");
    }

}