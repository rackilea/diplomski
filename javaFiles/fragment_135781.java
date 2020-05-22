try (BufferedReader br = new BufferedReader(
       new InputStreamReader(openFileInput(MainActivity.FILE_SERVERS)))) {
    String line = null;  // start with null in case there is no line
    while ((line = br.readLine()) != null) {
        String[] tokens = line.split(",");
        MCServer server = 
            new MCServer(tokens[0], tokens[1], tokens[2], tokens[3], 
              Boolean.parseBoolean(tokens[4]));
        servers.add(server);
    }
}