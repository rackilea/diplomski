private static String readWithEncode(byte[] data, String encoding) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data), encoding));
    StringBuilder result = new StringBuilder();
    String s;
    while ((s = br.readLine()) != null) {
        result.append(s);
    }
    br.close();
    return result.toString();
}