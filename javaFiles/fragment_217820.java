public static String getResponse(final ConnectionSettings settings, 
        String request) throws IOException {

    String url = settings.getUrl() + "/" + request;

    Authenticator.setDefault(new Authenticator() {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            System.out.println(getRequestingScheme() + " authentication")
            // Remember to include the NT domain in the username
            return new PasswordAuthentication(settings.getDomain() + "\\" + 
                settings.getUsername(), settings.getPassword().toCharArray());
        }
    });

    URL urlRequest = new URL(url);
    HttpURLConnection conn = (HttpURLConnection) urlRequest.openConnection();
    conn.setDoOutput(true);
    conn.setDoInput(true);
    conn.setRequestMethod("GET");

    StringBuilder response = new StringBuilder();
    InputStream stream = conn.getInputStream();
    BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    String str = "";
    while ((str = in.readLine()) != null) {
        response.append(str);
    }
    in.close();

    return response.toString();
}