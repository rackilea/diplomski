int width = 5;
    // for all lines; number of lines = width
    for (int line = 1; line <= width; line++) {
        // print numbers from 1 to current line number  
        for (int n = 1; n <= line; n++) {
            System.out.print(n);
        }
        // end of line
        System.out.println();
    }
    // add empty line between triangles
    System.out.println();
    // for all lines; number of lines = width
    for (int line = 1; line <= width; line++) {
        // printing padding spaces, number of spaces = with - line number
        int nSpaces = width - line;
        for (int i = 0; i < nSpaces; i++) {
            System.out.print(" ");
        }
        // print numbers from number of current line to 1
        for (int n = line; n >= 1; n--) {
            System.out.print(n);
        }
        // end of line
        System.out.println();
    }