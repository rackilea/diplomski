private static void displayMessageAndWait(String message) {
    System.out.println(message);
    try {
        Thread.sleep(2500L);
    } catch (InterruptedException e) {
    }
}