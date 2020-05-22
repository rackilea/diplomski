public class Test {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments!");
        } else if (args[0].equals("-i")) {
            System.out.println("-i passed");
        } else {
            System.out.println("Something else");
        }
    }
}