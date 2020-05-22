public static void main(String[] args) throws IOException {
    ConsoleReader in = new ConsoleReader();
    new Thread() {
        @Override
        public void run() {
            while (true) {
                try {
                    println(in, new Date().toString());
                    Thread.sleep(100);
                } catch (IOException | InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

    }.start();
    while (true) {
        in.readLine("> ");
    }
}