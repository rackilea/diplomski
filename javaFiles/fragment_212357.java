public static void appendToFileUtf8(String file, String data) {
    try {
        FileOutputStream fout = new FileOutputStream(file, true);
        OutputStreamWriter outwrite = new OutputStreamWriter(fout, "UTF-8");
        outwrite.write(data);
        outwrite.close();
    } catch (IOException e) {
        throw new RuntimeException("Error writing to file: "+file+" "+e.getMessage());
    }
}