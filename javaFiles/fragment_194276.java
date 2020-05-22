public static List<String> linesFromTo(int from, int to, String fileName)
        throws FileNotFoundException, IllegalArgumentException {
    return linesFromTo(from, to, fileName, "UTF-8");
}

public static List<String> linesFromTo(int from, int to, String fileName, String charsetName)
        throws FileNotFoundException, IllegalArgumentException {

    if(from > to) {
        throw new IllegalArgumentException("'from' > 'to'");
    }
    if(from < 1 || to < 1) {
        throw new IllegalArgumentException("'from' or 'to' is negative");
    }

    List<String> lines = new ArrayList<String>();
    Scanner scan = new Scanner(new File(fileName), charsetName);
    int lineNumber = 0;

    while(scan.hasNextLine() && lineNumber < to) {
        lineNumber++;
        String line = scan.nextLine();
        if(lineNumber < from) continue;
        lines.add(line);
    }

    if(lineNumber != to) {
        throw new IllegalArgumentException(fileName+" does not have "+to+" lines");
    }

    return lines;
}