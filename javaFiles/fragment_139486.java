public void handleCSV() {
    Path path = Paths.get("C:\\Temp\\", "loadtest.csv");

    Charset charset = Charset.forName("ISO-8859-1"); // <- the actual
                                                        // charset of you
                                                        // csv

    List<String> finalLine = new ArrayList<>();

    try {
        List<String> lines = Files.readAllLines(path, charset);

        boolean isFirstLine = true;
        int index = 0;
        for (String line : lines) {
            String[] lineContent = line.split(",");
            for (String column : lineContent) {
                if (isFirstLine) {
                    finalLine.add(column);
                } else {
                    String myEntry = finalLine.get(index);
                    myEntry.concat("," + column);
                    finalLine.set(index, myEntry);
                }
                index++; // adding an index for each element in the row
            }
            index = 0;
            isFirstLine = false;
        }
    } catch (IOException e) {
        System.out.println(e);
    }
}