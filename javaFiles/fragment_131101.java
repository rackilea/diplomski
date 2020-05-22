public static String skipEmptyLines(Scanner fileIn) {
    String line = "";
    while (fileIn.hasNext()) {
        if (!(line = fileIn.nextLine()).isEmpty()) {
            return line;
        }
    }
    return null;
}