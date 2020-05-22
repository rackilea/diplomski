private void whatever(String ip) {
    String ipinfo = getHttp("http://ip-api.com/line/" + ip + "?fields=49471");
    if (ipinfo == null || !ipinfo.startsWith("success")) {
        // TODO: failed
        return;
    }
    String[] lines = ipinfo.split("\n");
    // TODO: now you can get the info
    String country = lines[1];
    /*
    ...
     */
}

private static String getHttp(String url) {
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line).append(System.lineSeparator());
        }
        br.close();
        return sb.toString();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}