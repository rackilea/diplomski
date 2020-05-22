public void methodThatPrintsCaller() {
    StackTraceElement elem = Thread.currentThread.getStackTrace()[2];
    System.out.println(elem);

    // rest of you code
}