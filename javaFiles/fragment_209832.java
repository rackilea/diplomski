public static void main(String[] args) {

    // TODO 4 U: get the values for the header somehow
    String headerLine = "NAME, UNIV, DEGREE, COURSE";

    // TODO 4 U: read the txt output
    String txtOutput = "John MIT Bachelor ComputerScience Mike UB Master ComputerScience";

    /*
     * then split the header line
     * (or do anything similar, I don't know where your header comes from)
     */
    String[] headers = headerLine.split(", ");

    // store the amount of headers, which is the amount of columns
    int amountOfColumns = headers.length;

    // split txt output data by space
    String[] data = txtOutput.split(" ");

    /*
     * declare a data structure that stores lists of Strings,
     * each one is representing a line of the csv file
     */
    Map<Integer, List<String>> linesForCsv = new TreeMap<Integer, List<String>>();

    // get the length of the txt output data
    int a = data.length;

    // create a list of Strings containing the headers and put it into the data structure
    List<String> columnHeaders = Arrays.asList(headers);
    linesForCsv.put(0, columnHeaders);

    // declare a line counter for the csv file
    int l = 0;
    // go through the txt output data in order to get the lines for the csv file
    for (int i = 0; i < a; i++) {
        // check if there is a new line to be created
        if (i % amountOfColumns == 0) {
            /*
             * every time the amount of headers is reached,
             * create a new list for a new line in the csv file
             */
            l++; // increment the line counter (even at 0 because the header row is inserted at 0)
            linesForCsv.put(l, new ArrayList<String>()); // create a new line-list
            linesForCsv.get(l).add(data[i]); // add the data to the line-list
        } else {
            // if there is no new line to be created, store the data in the current one
            linesForCsv.get(l).add(data[i]);
        }
    }

    // print the lines stored in the map
    // TODO 4 U: write this to a csv file instead of just printing it to the console
    linesForCsv.forEach((lineNumber, line) -> {
        System.out.println("Line " + lineNumber + ": " + String.join(",", line));
    });
}