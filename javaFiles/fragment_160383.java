try {
    execMethod("123");
    try {
        execMethod("456");
    } catch (Exception ex) {
        // Maybe undo 123
        System.out.println("Failed 456");
        ex.printStackTrace();
    }
} catch (Exception ex) {
    System.out.println("Failed 123");
    ex.printStackTrace();
}