final PrintStream consoleOutput = System.out;
    final PipedOutputStream testInput = new PipedOutputStream();
    final PipedOutputStream out = new PipedOutputStream();
    final PipedInputStream testOutput = new PipedInputStream(out);
    System.setIn(new PipedInputStream(testInput));
    System.setOut(new PrintStream(out));
    new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                PrintStream testPrint = new PrintStream(testInput);
                BufferedReader testReader = new BufferedReader(
                    new InputStreamReader(testOutput));
                while (true) {
                    testPrint.println((int) (Math.random() * 100));
                    consoleOutput.println(testReader.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace(consoleOutput);
            }
        }
    }).start();
    guessingGame();