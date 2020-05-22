public static void main(String[] args) {
    /**
     * Read in "./Root/files/echo.csv" und "./Root/files/file1.csv"
     * and output the respective warning on System.out
     */
    String[][] codeexpert = CSVReader.readCSV("./Root/files/file1.csv");
    String[][] echo = CSVReader.readCSV("./Root/files/echo.csv");
    String msg = "The two files provided are not the same!";

    // See if the two arrays are of the same length.
    // This would be a dead give-away right from the start.
    if (codeexpert.length != echo.length) {
        System.err.println(msg);
        return;
    }

    // See if the lines in each file are the same. We check
    // the rows and columns of each 2D Array to do this.
    // Trap exceptions in case Array column indexing is different
    // on both 2D Arrays.
    try {
        // Get Row...
        for (int i = 0; i < codeexpert.length; i++) {
            // Get Coloumn...
            for (int j = 0; j < codeexpert[i].length; j++) {
                // Is the data in the columns of this particular row
                // the same in both arrays?
                if (!codeexpert[i][j].equals(echo[i][j])) {
                    // No it's not...  
                    System.err.println(msg);
                    return; 
                } 
            }
            System.out.println("File 1 - Line " + String.valueOf(i + 1) + ": " + Arrays.toString(codeexpert[i]));
            System.out.println("File 2 - Line " + String.valueOf(i + 1) + ": " + Arrays.toString(echo[i]));
        }
    } 
    catch (Exception ex) {
        // If the exception occurs then chances are the indexing
        // for columns is different on a particular row. 
        System.err.println(msg);
        return;
    }
    System.out.println("The two files are the same!");
}