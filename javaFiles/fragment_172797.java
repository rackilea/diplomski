Scanner in = new Scanner(f);
String dataLine;
while (in.hasNextLine()) {
    dataLine = in.nextLine().trim();
    // Skip Blank Lines
    if (dataLine.equals("")) {
        continue;
    }
    System.out.println(dataLine);
}