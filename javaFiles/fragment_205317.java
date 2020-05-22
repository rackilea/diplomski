public static int[][] importFile(String fileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    int[][] numArray;
    String line = reader.readLine();
    if (line == null) {
        throw new IllegalArgumentException("There was no 1st line.");
    }
    String[] dimensions = line.split("\\s+");
    try {
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        // TODO: check for negative values.
        numArray = new int[rows][cols];
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("First line of file has to be 'rows cols'");
    }

    int row = 0; 

    while ((line = reader.readLine()) != null && row < numArray.length) {
        String[] tokens = line.split("\\s+");
        if (tokens.length > numArray[row].length) {
            throw new IllegalArgumentException("Too many values provided in matrix row " + row);
        }
        // to less values will be filled with 0. If you don't want that
        // you have to uncomment the next 3 lines.
        //if (tokens.length < numArray[row].length) {
        //  throw new IllegalArgumentException("Not enough values provided in matrix row " + row);
        //}
        for(int column = 0; column < tokens.length; column++) {
            try {
                int value = Integer.parseInt(tokens[column]);
                numArray[row][column] = value; 
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Non numeric value found in matrix row " + row + ", column " + column);
            }
        }
        row++;
    }
    if (line != null) {
        // there were too many rows provided.
        // Superflous ones are ignored.
        // You can also throw exception, if you want.
    }
    if (row < numArray.length) {
        // There were too less rows in the file. If that's OK, the
        // missing rows will be interpreted as all 0.
        // If that's OK with you, you can comment out this whole
        // if block
        throw new IllegalArgumentException("Expected " + numArray.length + " rows, there only were " + row);
    }
    try {
        reader.close(); // never forget to close a stream.
    } catch (IOException e) { }
    return numArray;
}