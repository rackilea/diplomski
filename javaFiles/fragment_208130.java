MyRunnableClass mrc = new MyRunnableClass();
mrc.setListener(new Listener() {
    @Override
    public void onError(Throwable error) {

    }
});

Executors.newSingleThreadScheduledExecutor().schedule(mrc, 1000L, TimeUnit.MILLISECONDS);