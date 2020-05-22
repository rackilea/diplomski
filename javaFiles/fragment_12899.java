public static void main(String[] args) throws IOException, InterruptedException {
    // wait time of 1/3 a second in milliseconds
    long waitTime = (long) ((1.0 / 3.0) * 1000.0);
    // standard input buffered reader
    try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
        // loop for 100 polls used in testing (replace with game loop here)
        for (int i = 0; i < 100; i++) {
            // wait for user to input data
            Thread.sleep(waitTime);
            String s = null;
            while (in.ready()) {
                // get the last thing the user has input in the 1/3 second
                // to protect you from multiple inputs
                s = in.readLine();
            }
            if (s != null) {
                // handle user input here
                System.out.println("User input: " + s);
            } else {
                // handle no user input here
            }
        }
    }
}