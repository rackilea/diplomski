public class TestForArgs {

    public static void main(String[] args) throws Exception {
        if (args == null) {
            System.out.println("args == null");
        }
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}