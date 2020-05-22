private static openandprint() throws IOException {
    int i = 0;
    try (Scanner s = new Scanner("final.txt")))  {
        String line;
        while (s.hasNextLine()) {
            int change2Int = s.nextInt();
            s.nextLine(); // ignore the rest of the line
            figures [i] = change2Int;
            i++;
        }
    }
}