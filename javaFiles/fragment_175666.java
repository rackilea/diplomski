...
    System.out.println("Gathering data for 60 seconds\n\n");
    try {
        Thread.sleep(60000);
    } catch (InterruptedException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    Executors.newScheduledThreadPool(1).schedule(() -> {
        phid1.close();
        phid2.close();
        System.out.println("\nClosed RFIDs");
    }, 60, TimeUnit.SECONDS);
}