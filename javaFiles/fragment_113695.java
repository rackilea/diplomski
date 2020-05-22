public static String streamToString(InputStream in) {

    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();

    String line;
    try {

        br = new BufferedReader(new InputStreamReader(in));
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

    } catch (IOException e) {
        Log.e(e);
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                Log.e(e);
            }
        }
    }

    return sb.toString();
}


public static InputStream stringToStream(String text) {

    try {
        return new ByteArrayInputStream(text.getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
        Log.e(e);
        return null;
    }
}


public static InputStream getResource(String path) {

    return FileUtils.class.getResourceAsStream(path);
}