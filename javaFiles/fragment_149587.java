public String file2string() {
    String line = null;
    try (InputStream fis = new FileInputStream("smth")) {
        InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
        BufferedReader br = new BufferedReader(isr);

        while ((line = br.readLine()) != null) {
            String[] words = line.split(" ");
            // Now you have a String array containing each word in the current line
        }
    } catch (IOException ex) {
        Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
    }  
    return line;
}