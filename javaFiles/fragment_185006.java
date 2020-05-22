public static void handleExceptions(Runnable r) {
    try {
        r.run();
    }
    catch(RuntimeException ex) {
        ex.printStackTrace();
    }
}