List<String> inputLines = ...

List<String> outputLines = new LinkedList<String>();
int lastInt = 0;
int lastDouble = 0;
boolean firstValue = true;
for (String line : inputLines) {
    // Split by ",", then values[0] is the integer and values[1] the double
    String[] values = line.split(",");
    int currentInt = Integer.parseInt(values[0]);
    double currentDouble = Double.parseDouble(values[1]);

    if (firstValue) {
        // Nothing to compare to on the first run
        firstValue = false;
    } else {
        // Compare to last values and build the result
        int diffInt = lastInt - currentInt;
        double diffDouble = lastDouble - currentDouble;

        String outputLine = diffInt + "," + diffDouble;
        outputLines.add(outputLine);
    }

    // Current values become last values
    lastInt = currentInt;
    lastDouble = currentDouble;
}