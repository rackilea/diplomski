try {
    for (int i = 0; i < importantInfo.length; i++) {
        // Pause for 4 seconds
        Thread.sleep(4000);

        // Print a message
        System.out.println(importantInfo[i]);
    }
} catch (InterruptedException e) {
    // We've been interrupted: no more messages.
    Thread.currentThread().interrupt();
}