BufferedReader reader = new BufferedReader(new FileReader("myData.in"));
String currentLine;

try {
    while ((currentLine = reader.readLine()) != null) {
        Scanner scanner = new Scanner(currentLine);

        try {
            calculateTriangleArea(
                scanner.nextInt(), scanner.nextInt(), scanner.nextInt()
            );
        }
        catch (NoSuchElementException e) {
            // invalid line
        }
    }
}
finally {
    reader.close();
}