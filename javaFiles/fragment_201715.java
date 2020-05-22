public void addAssociation(final Association association) {
    final CountDownLatch latch = new CountDownLatch(1);
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            if (!associationList.contains(association)) {
                associationArrayAdapter.add(association);
            }
            latch.countDown();
        }
    });
    try {
        latch.await();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    if (!associationList.contains(association)) {
        associationList.add(association);
    }
}