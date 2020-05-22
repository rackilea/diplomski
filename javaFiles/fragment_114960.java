@Override
protected String doInBackground(Void... params) {
    return get("http://192.168.43.13:8000/api/horaire.json");
}

private String get(String urlString) {
    try {
        HttpURLConnection urlConnection = (HttpURLConnection) new URL(urlString).openConnection();
        Reader reader = new InputStreamReader(urlConnection.getInputStream());
        try {
            StringWriter writer = new StringWriter();
            char[] cbuf = new char[8192];
            int read;
            while ((read = reader.read(cbuf)) != -1) {
                writer.write(cbuf, 0, read);
            }
            return writer.toString();
        } finally {
            reader.close();
        }
    } catch (Exception e) {
        return e.getMessage();
    }
}