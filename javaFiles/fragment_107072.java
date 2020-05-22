public class TesteArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Inform a valid name...");
            System.exit(0);
        }
        // continue handling your args param
        System.out.println(args[0]);
    }
}