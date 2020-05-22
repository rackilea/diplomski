public static ArrayList<int[]> readMaze(String fileName) {

    // Number of ints per line:
    int width=2;

    // This will be the output - a list of rows, each with 'width' entries:
    ArrayList<int[]> results=new ArrayList<int[]>();

    String line = null;

    try {
        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Scanner mazeRunner = new Scanner(bufferedReader);

        // While we've got another line..
        while (mazeRunner.hasNextLine()) {

            // Setup current row:
            int[] row = new int[width];

            // For each number..
            for (int i = 0; i < width; i++) {

                // Read the number and add it to the current row:
                row[i] = mazeRunner.nextInt();

            }

            // Add the row to the results:
            results.add(row);

            // Go to the next line (optional, but helps deal with erroneous input files):
            if ( mazeRunner.hasNextLine() ) {

                // Go to the next line:
                mazeRunner.nextLine();

            }

        }

        mazeRunner.close();

    }

    catch (FileNotFoundException ex) {
        System.out.println("Unable to open file: " + fileName);
    }

    catch (IOException ex) {
        System.out.println("Error reading file: " + fileName);
    }

    return results;

}