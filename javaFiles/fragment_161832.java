int N = 0;
    int M = 0;

    String part1 = null;
    String part2 = null;

    java.io.File file = new java.io.File("gene57.txt");
    try {
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String num = input.nextLine();

            String[] parts = num.split(" ");
            part1 = parts[0];
            N = part1.length();

            part2 = parts[1];
            M = part2.length();

            System.out.println(part1);
            System.out.println("Number of nucleobase of Sequence 1 is=" + N);

            System.out.println(part2);
            System.out.println("Number of nucleobase of Sequence 2 is=" + M);
        }
    }

    catch (FileNotFoundException e) {
        System.err.format("File does not exist\n");
    }

    char [][] opt = new char [N + 2][M + 2]; // + 1 for the indicator row/column + 1 for the extra field

    opt[0] = part1.toCharArray();

    char[] temp = part2.toCharArray();

    for (int count = 1; count < M + 1; count++) {
        opt[count][0] =  temp[count - 1];
    }

    // Add '-' for the extra row at the bottom.
    opt[M + 1][0] = '-';        


    // Here you need to do your dynamic programming using op[][] and once you're done
    // you should have a 2d array of integers we'll just call it result[][] for now.

    // replace with the method that computes and returns result! We'll just use these values for now.
    int[][] result = {{1, 2, 3, 4, 5}, {5, 6, 7, 8, 9}, {9, 10, 11, 12, 13}, {13, 14, 15, 16, 17}, {17, 18, 19, 20, 21}};        

    // Printing the matrix

    StringBuilder firstLine = new StringBuilder("      |"); 
    StringBuilder secondLine = new StringBuilder("   x/y|");
    StringBuilder horizontalLine = new StringBuilder("________");

    int count = 0;

    for (count = 0; count < N; count++) {
        if (count < 9) {
            // 1 digit
            firstLine.append("  " + count);
            secondLine.append("  " + opt[0][count]);
            horizontalLine.append("___");
        } else {
            // 2 digits
            firstLine.append(" " + count);
            secondLine.append(" " + opt[0][count]);
            horizontalLine.append("___");
        }
    }

    // Add the extra column at the end for '-'.
    if (count > 9) {
        firstLine.append(" " + count);
        secondLine.append(" -");
        horizontalLine.append("___");
    } else {
        firstLine.append("  " + count);
        secondLine.append("  -");
        horizontalLine.append("___");
    }

    System.out.println(firstLine.toString());
    System.out.println(secondLine.toString());
    System.out.println(horizontalLine.toString());

    for (count = 0; count < M + 1; count++) {

        StringBuilder line = new StringBuilder();

        // Add the indicator stuff
        if (count > 9) {
            line.append(" " + count + " " + opt[count + 1][0] + " |");
        } else {
            line.append("  " + count + " " + opt[count + 1][0] + " |");
        }

        for (int index = 0; index < N + 1; index++) {

            // Add the results
            if (result[count][index] > 9) {
                line.append(" " + result[count][index]);
            } else {
                line.append("  " + result[count][index]);
            }
        }

        // Print the line
        System.out.println(line.toString());
    }