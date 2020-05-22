for (int r=0; r<returnchar.length; r++) { // "r" for row
    String line = input.nextLine();
    String[] splitter = line.split(" ", 2);
    for (int c=0; c<returnchar[r].length; c++) { // "c" for column
        returnchar[r][c] = splitter[c];
    }
}