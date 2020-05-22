public static void main(String[] args) throws IOException {
    StringBuilder text = new StringBuilder();
    // StringBuilder google
    // google end of file check java

    InputStream in = new FileInputStream("charfile.txt");
    Reader r = new InputStreamReader(in, "US-ASCII");
    int intch;
    {
        while ((intch = r.read()) != -1) {
            char ch = (char) intch;
            // ...
            text.append(ch); 
        }
    }
}