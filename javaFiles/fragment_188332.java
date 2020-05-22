try {
    Scanner scan = new Scanner(f);
    String infoLine = scan.nextLine();
    int rows = 0;
    int columns = 0;
    for (int i = 0; i < infoLine.length();i++) {
        if (Character.isDigit(infoLine.charAt(i))) {
            rows = Character.digit(infoLine.charAt(i), 10);
            columns = Character.digit(infoLine.charAt(i + 1), 10);
            break;
        }
    }

    String [][] maze = new String[rows][columns];
    int r = 0;
    while(scan.hasNextLine() && r < rows) {
        int c = 0;
        while(scan.hasNextLine() && c < columns) {
            maze[r][c]=scan.next();
            c++
        }
        r++;
    }
    return maze;
} catch (FileNotFoundException e) {
    e.printStackTrace();
}