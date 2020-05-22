static void updateIp() throws MalformedURLException, IOException {
    String urlParameters = "name=sub&a=rec_edit&id=9001";
    URL url = new URL("http://httpbin.org/post");
    URLConnection con = url.openConnection();

    con.setDoOutput(true);

    BufferedReader reader;
    try (OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream())) {
        writer.write(urlParameters);
        writer.flush();
        String line;
        StringBuilder urlResponse = new StringBuilder();
        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        while ((line = reader.readLine()) != null) {
            urlResponse.append(line);
        }
        String response = urlResponse.toString();
        System.out.println(response);
    }
    reader.close(); 
}