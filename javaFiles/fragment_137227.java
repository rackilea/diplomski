public static String convertStreamToString(InputStream is) throws UnsupportedEncodingException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
    StringBuilder sb = new StringBuilder();
    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
    } catch (IOException e) {
    } finally {
        try {
            is.close();
        } catch (IOException e) {
        }
    }
    return sb.toString();
}