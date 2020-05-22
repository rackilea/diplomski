public class MyShell {
    private static final String UP_ARROW_1 = new String(new byte[] {91, 65});
    private static final String UP_ARROW_2 = new String(new byte[] {27, 91, 65});
    private static final String DN_ARROW_1 = new String(new byte[] {91, 66});
    private static final String DN_ARROW_2 = new String(new byte[] {27, 91, 66});

    // (...)

    public static void main(String[] args) throws IOException {
        // (...)
            // history
            else if (commandLine.startsWith(UP_ARROW_1) || commandLine.startsWith(UP_ARROW_2)) {
                System.out.println("up arrow");
            }
            else if (commandLine.startsWith(DN_ARROW_1) || commandLine.startsWith(DN_ARROW_2)) {
                System.out.println("down arrow");
            }
        // (...)
    }
}