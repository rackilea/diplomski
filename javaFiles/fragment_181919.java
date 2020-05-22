public static void main(String[] args) {
    // Number of rows
    int nRows = 4;

    for (int i = 0; i <= nRows; i++) {
        StringBuilder string = new StringBuilder();

        for (int k = i; k <= nRows; k++) {
            // Prints a white space before the first '//' symbol
            string.append(" ");
        }

        // Prints the '//' symbol
        string.append("//");

        int z = (i + i) / 2;

        for (int j = 1; j <= z; j++) {
            // Prints the first half of white space between the '//' and '\\'
            string.append(" ");
        }

        for (int j = 1; j <= z; j++) {
            // Prints the second half of white space between the '//' and '\\'
            string.append(" ");
        }

        // Prints the '\\\\.' symbol
        string.append("\\\\.");


        for (int k = i; k <= nRows; k++) {
            // Prints a white space before the '\\.' symbol
            string.append(" ");
        }
        // Prints white spaces before the 'o' at the end
        string.append("o");
        System.out.println(string);

    }
}