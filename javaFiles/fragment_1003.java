HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
final int responseCode = connection.getResponseCode();
if (responseCode < 200 || responseCode > 299) {
    log.info("Response " + responseCode + " opening connection to " + url);
    return;
}
try (Reader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
    InputSource is = new InputSource(reader);
    is.setEncoding( "UTF-8" );
    parser.parse(is, handler);
}