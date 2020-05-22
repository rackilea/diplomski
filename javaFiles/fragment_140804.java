public static void main(String[] arghhhhh) {
    try {
        ...
    } catch (Throwable ex) {
        System.err.println("Uncaught exception - " + ex.getMessage());
        ex.printStackTrace(System.err);
    }
}