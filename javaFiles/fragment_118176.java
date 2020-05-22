ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            ex.schedule(new UpdatingService(), 1, TimeUnit.MILLISECONDS);
        }
    });