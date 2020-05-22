public static String readAsString(InputStream is) throws IOException {
    BufferedReader reader = null;
    StringBuilder sb = new StringBuilder();
    try {
        String line;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            reader = new BufferedReader(new InputStreamReader(is,UTF_8));
        }
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
    } finally {
        if (reader != null) {
            reader.close();
        }
    }
    return sb.toString();
}