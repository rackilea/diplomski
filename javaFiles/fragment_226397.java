StringBuffer returnJson(URL url) throws IOException {
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    InputStream iStream = conn.getInputStream();

    BufferedReader read = new BufferedReader(new InputStreamReader(iStream));

    String line;
    StringBuffer val = new StringBuffer();

    while((line = read.readLine())!=null){
        val.append(line);
    }

    return val;
}