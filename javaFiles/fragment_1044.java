public class SelectMethod {
    public static void sendToSales() {
        System.out.println("Sending mail to sales team...");
    }

    public static void sendToOther() {
        System.out.println("Sending mail to other team...");
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("No required parameter passed\n"
                    + "Valid options: sales, other");
            System.exit(1);
        }

        if ("sales".equals(args[0])) {
            sendToSales();
        } else if ("other".equals(args[0])) {
            sendToOther();
        }
    }
}