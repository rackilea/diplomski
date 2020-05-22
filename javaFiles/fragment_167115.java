@Override
protected void setupConnection(Message message, Address address, HTTPClientPolicy csPolicy) throws IOException {
    super.setupConnection(message, address, csPolicy);
    HttpURLConnection connection = (HttpURLConnection) message.get(KEY_HTTP_CONNECTION);
    decorateHttpsURLConnection((HttpsURLConnection) connection);\
    message.put(KEY_HTTP_CONNECTION, connection);
}