public static void main(String[] args) throws IOException {
    final File file = new File("myFile");
    try (final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            final String[] words = line.split("\\b");
            System.out.println(words.length + " words in line \"" + line + "\".");
        }
    }
}