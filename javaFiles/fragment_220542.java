@Test public void pipe() throws IOException, InterruptedException {
    Runtime.getRuntime().exec("mkfifo mypipe");

    final String[] read = new String[1];
    Thread t = new Thread() {
        @Override
        public void run() {
            try {
                BufferedReader r = new BufferedReader(new FileReader("mypipe"));
                read[0] = r.readLine();
            } catch (IOException e) {
            }
        }
    };
    t.start();

    FileWriter w = new FileWriter("mypipe");
    w.write("hello\n");
    w.flush();
    t.join();

    assertEquals("hello", read[0]);
}