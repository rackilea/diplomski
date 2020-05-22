public static void printCombinations(int R, int N) {
    // calculate the combinations
    String[][] combinations = calculateCombinations(R, N);
    // iterate over all
    for (int i = 0; i < combinations.length; i++) {
        // prints the commas at the end
        if (i != 0) {
            System.out.println(',');
        }
        // print to std out
        System.out.print(Arrays.toString(combinations[i]));
    }
    System.out.println();
}

public static String[][] calculateCombinations(int R, int N) {
    // calculate our limit
    int limit = (int) StrictMath.pow(N, R);
    // create the result array
    String[][] result = new String[limit][R];
    // iterate over all possibilities
    for (int i = 0; i < limit; i++) {
        // convert to base
        String base = Long.toString(i, N);
        // holds our temporary value
        StringBuilder intermediate = new StringBuilder(R);
        // pad the value from the start with zeroes if needed
        for (int sub = R - base.length(); sub > 0; sub--) {
            intermediate.append('0');
        }
        // append our number
        intermediate.append(base);

        // append to result
        result[i] = intermediate.toString().split("");
    }
    // return the result
    return result;
}