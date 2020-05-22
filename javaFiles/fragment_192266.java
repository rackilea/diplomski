final Handler uiHandler = new Handler(Looper.getMainLooper());

void scheduleToasts(String... messages) {
    final List<String> list = Arrays.asList(messages);
    Collections.reverse(list);

    final AtomicInteger countdown = new AtomicInteger(list.size());
    final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    service.scheduleWithFixedDelay(() -> {
        final int count = countdown.getAndDecrement();
        if(count == 0) {
            service.shutdown();
            return;
        }

        uiHandler.post(() -> Toast.makeText(getContext(), list.get(count), Toast.LENGTH_LONG).show());
    }, 0, 3500, TimeUnit.MILLISECONDS);
}