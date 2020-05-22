for (final String name : clients) {
    cs.submit(new NameProcessor(name));
}
final Collection<Collection<String>> proccessedClients = new LinkedList<>();
for (int i = 0; i < clients.size(); ++i) {
    try {
        proccessedClients.add(cs.take().get());
    } catch (InterruptedException ex) {
        return;
    } catch (ExecutionException ex) {
        throw new RuntimeException(ex);
    }
}