class PrintBuilder {
    List<Printer> printers = new LinkedList<>();

    PrintBuilder add(String line) {
        printers.add(new Printer(line));
        return this;
    }

    List<Printer> get() {
        return printers;
    }

    static class Printer implements Runnable {
        String line;

        Printer(String line) {
            this.line = line;
        }

        public void run() {
            System.out.println(line);
        }
    }
}