for (int i = 0; i < rows; i++) {
    String temp = scan.nextLine();
    for (int j = 0; j < columns; j++) {
        wordSearch[i][j] = temp.charAt(j);
    }
}