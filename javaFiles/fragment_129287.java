String data = "1|apple,2|ball,3|cat";
    String[] rows = data.split(",");

    String[][] matrix = new String[rows.length][]; 
    int r = 0;
    for (String row : rows) {
        matrix[r++] = row.split("\\|");
    }

    System.out.println(matrix[1][1]);
    // prints "ball"

    System.out.println(Arrays.deepToString(matrix));
    // prints "[[1, apple], [2, ball], [3, cat]]"