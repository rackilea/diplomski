public class EarlyReturn {
    public static void whatHappens(final Boolean path) {
        System.out.println("Entering method...");

        if (path == null) {
           throw new IllegalArgumentException("Must have a path.");
        } else if (path) {
            System.out.println("Exiting early...");
            return;
        }

        System.out.println("Exiting normally...");
    }
}