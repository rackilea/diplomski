int TIMEOUT_VALUE = 1000;
    try {
        URL testUrl = new URL("http://google.com");
        StringBuilder answer = new StringBuilder(100000);

        long start = System.nanoTime();

        URLConnection testConnection = testUrl.openConnection();
        testConnection.setConnectTimeout(TIMEOUT_VALUE);
        testConnection.setReadTimeout(TIMEOUT_VALUE);
        BufferedReader in = new BufferedReader(new InputStreamReader(testConnection.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            answer.append(inputLine);
            answer.append("\n");
        }
        in.close();

        long elapsed = System.nanoTime() - start;
        System.out.println("Elapsed (ms): " + elapsed / 1000000);
        System.out.println("Answer:");
        System.out.println(answer);
    } catch (SocketTimeoutException e) {
        System.out.println("More than " + TIMEOUT_VALUE + " elapsed.");
    }