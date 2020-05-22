public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(
             new InputStreamReader(new FileInputStream("src/wordlist"), "UTF-8"));
         BufferedWriter writer = new BufferedWriter(new FileWriter(
             new File("src/newwordlist.txt")));
        HashSet<String> db = new HashSet<>();
        String EOL = System.getProperty("line.separator");
        String word;
        int i = 0;
        while ((word = reader.readLine()) != null) {
            i++;
            Stemmer s = new Stemmer();
            s.addword(word);
            s.stem();
            String stem = s.toString();
            if (db.add(stem)) {
                writer.write(stem);
                writer.write(EOL);
            }
        }
        System.out.println("Reduced file from " + i + " words to " + db.size());
    } catch (IOException e1) {
        e1.printStackTrace();
    }
}