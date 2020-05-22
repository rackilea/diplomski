public static void main(String[] args) {
    // Number of rows
    int nRows = 4;

    for (int i = 0; i <= nRows; i++) {
        StringBuilder string = new StringBuilder();
        string.append("o");

        for (int k = i; k <= nRows; k++) {
            // Adds a white space before the first '//' symbol
            string.append(" ");
        }

        // Adds the '//' symbol
        string.append("//");

        int z = (i + i) / 2;

        for (int j = 1; j <= z; j++) {
            // Adds the first half of white space between the '//' and '\\'
            string.append(" ");
        }

        for (int j = 1; j <= z; j++) {
            // Adds the second half of white space between the '//' and '\\'
            string.append(" ");
        }

        // Adds the '\\\\.' symbol
        string.append("\\\\.");

        // Prints the string
        System.out.println(string);

    }
}