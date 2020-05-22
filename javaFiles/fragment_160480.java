protected String doInBackground(String... params) {
    URL url = null;
    String result = "";
    try {
        url = new URL("http://www.example.com/description1.txt");
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        in.close();

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return result;
}