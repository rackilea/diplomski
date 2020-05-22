class PrintBuilder {
    List<Runnable> printers = new LinkedList<>();

    List<Runnable> get() {
        return printers;
    }

    PrintBuilder add(final String line) {
        printers.add(new Runnable() {
            public void run() {
                System.out.println(line);
            }
        });

        return this;
    }
}