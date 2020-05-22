private static String getHtml(String location) throws IOException {
    URL url = new URL(location);
    URLConnection conn = url.openConnection();
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String input;
    StringBuilder builder = new StringBuilder();
    while((input = in.readLine()) != null)
    {
         builder.append(input);
    }

    return builder.toString();
}