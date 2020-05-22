BufferedReader reader = null;
try {
    reader = new BufferedReader(new UnicodeReader(new FileInputStream(fileName), "UTF-8"));
    // ...
} finally {
    if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
}