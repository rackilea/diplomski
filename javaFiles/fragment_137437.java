class StackingListener implements MessageListener, Runnable {
    private final BlockingQueue<Message> messages = new LinkedBlockingDeque<Message>();
    private final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(); {
        service.scheduleAtFixedRate(this, 500, 500, TimeUnit.MILLISECONDS);
    }

    @Override
    public void messageReceived(MessageEvent event) {
        messages.add(event.getData());
    }

    @Override
    public void run() {
        final List<Message> list = new ArrayList<Message>();
        messages.drainTo(list);

        logger.info("Adding list with size of " + list.size());
        // add to the GUI component in a thread safe manner.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controller.getListModel().addFullElements(list);
            }
        });
    }

    public void stop() {
        service.shutdown();
    }
}