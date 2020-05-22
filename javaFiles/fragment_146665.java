public String apiPost(String urlString, String payload) {
    return commonMethod(urlString, payload, (connection) -> {
        // UNIQUE CODE START
        prepareConnection(connection, POST);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
        writer.write(payload);
        writer.close();
        // UNIQUE CODE END
    });
}

interface ConnectionWorker {
    void run(HttpURLConnection connection) throws IOException;
}

public String commonMethod(String urlString, String payload, ConnectionWorker worker) {
    boolean keepGoing = true;
    int tries = 0;

    String line;
    StringBuilder jsonString = new StringBuilder();

    log.debug("Making API Call: {}", urlString);

    while (keepGoing && tries < MAX) {
        tries++;
        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            worker.run(connection);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }
            br.close();
            connection.disconnect();
            keepGoing = false;
        } catch (Exception e) {
            log.warn("Try #{}. Error posting: {}", tries, e.getMessage());
            log.warn("Pausing for 1 second then trying again...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException f) {
                log.warn("Sleeping has been interrupted: {}", f.getMessage());
            }
        }
    }
    return jsonString.toString();
}