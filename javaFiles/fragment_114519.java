private final ExecutorService executor = new FixedThreadPool(N_THREADS);

private void send(Set<Client> clients, final Event event) {
    for (Client client : clients) {
        final Client c = client;
        executor.submit(new Runnable() { public void run() { sendTo(c, event); }});
    }
}