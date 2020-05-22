Thread worker = new Thread() {
    @Override
    public void run() {
        Files.copy(source, target, ExtendedCopyOption.INTERRUPTIBLE);
    }
}
worker.start();