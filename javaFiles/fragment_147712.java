public void doProcess() {
    for (int i = 0; i < noOfLists; i++) {
        final int index = i;
        // Using Lambda Expression as it is much cleaner
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            pleasePrint(mainList.get(index));   // Pass each list for printing
        }).start();
    }
}