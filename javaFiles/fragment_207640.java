public int getOffset(File file, String searched) throws FileNotFoundException {
    Scanner scanner = new Scanner(file).useDelimiter(System.getProperty("line.separator"));
    int occurences = 0;
    while (scanner.hasNextLine()) {
        String s = scanner.nextLine();
        if (s.indexOf(searched) >= 0) {
            occurences++;
        }
    }
    return occurences;
}