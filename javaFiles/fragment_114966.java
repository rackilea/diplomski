public class CharacterHandler {
    //Java 7 source level
    public static void main(String[] args) throws IOException {
        // replace this with a known encoding if possible
        Charset encoding = Charset.defaultCharset();
        for (String filename : args) {
            File file = new File(filename);
            handleFile(file, encoding);
        }
    }

    private static void handleFile(File file, Charset encoding)
            throws IOException {
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, encoding);
             // buffer for efficiency
             Reader buffer = new BufferedReader(reader)) {
            handleCharacters(buffer);
        }
    }

    private static void handleCharacters(Reader reader)
            throws IOException {
        int r;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            System.out.println("Do something with " + ch);
        }
    }
}