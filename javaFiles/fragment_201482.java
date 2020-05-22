Scanner sc = new Scanner(System.in);

    int rows = sc.nextInt();
    sc.nextLine(); // nextInt() didn't consume the newline so we do it here
    int[][] matrix = new int[rows][];

    for (int i = 0; i < rows; i++) {

        String line = sc.nextLine();
        String[] valueStrings = line.split("\\s+");

        matrix[i] = new int[valueStrings.length];

        for (int j = 0; j < valueStrings.length; j++) {

            matrix[i][j] = Integer.parseInt(valueStrings[j]);
        }

    }

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.print("" + matrix[i][j] + " ");
        }
        System.out.println();
    }