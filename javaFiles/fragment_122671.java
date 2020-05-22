final CountDownLatch clipDone = new CountDownLatch(1);
clip.addLineListener(new LineListener() {
    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.STOP) {
            event.getLine().close();
            clipDone.countDown();
        }
    }
});
// play the sound clip and wait until it is done
clip.start();
clipDone.await();