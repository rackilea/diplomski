final class NameProcessor implements Callable<Collection<String>> {

    private final String name;

    public NameProcessor(final String name) {
        this.name = name;
    }

    @Override
    public Collection<String> call() throws Exception {
        return Arrays.asList(name.split("\\s+"));
    }
}

final class TerroristProcessor implements Runnable {

    private final String name;

    public TerroristProcessor(final String name) {
        this.name = name;
    }

    @Override
    public void run() {
        final Set<String> splitName = new HashSet<>(Arrays.asList(name.split("\\s+")));
        for (final Collection<String> client : proccessedClients) {
            if (splitName.containsAll(client)) {
                System.out.println("Match found t:" + name + ", c:" + client);
            }
        }
    }
}