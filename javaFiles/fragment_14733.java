BufferedReader reader = new BufferedReader(new InputStreamReader(iSteamReader));
    String line;
    StringBuilder response = new StringBuilder();
    while ((line = reader.readLine()) != null) {
        response.append(line);
        response.append('\r');
    }