StringBuilder json = new StringBuilder();
try {
    URL url = new URL(sMyUrl);
    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    try {
        String str;
        while ((str = in.readLine()) != null) {
            json.append(str).append("\n");
        }
    } finally {
        in.close();
    }
} catch (Exception e) {
    throw new RuntimeException("Failed to read JSON from stream", e);
}