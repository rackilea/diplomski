private static void cancellaaaaaaaaable() throws InterruptedException {
    System.out.println("Cancellaaaaaaable!");
    System.out.print(ANSI_RED);

    InputStreamReader inStream = new InputStreamReader(System.in);
    BufferedReader bufferedReader = new BufferedReader(inStream);
    for (int i = 0; i < 79; i++) {

        System.out.print("█");
        TimeUnit.MILLISECONDS.sleep(500);

        // Something that allows user input/interaction capable to stop the progressbar
        try {
            if (bufferedReader.ready()) {
                break;
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    System.out.print(ANSI_RESET);
}