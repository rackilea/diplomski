int NUM_COLUMNS = 6;

char rowPrefix = 'A';
int colPrefix = 1;

Scanner s = new Scanner("/path/to/file.txt");
while (s.hasNextLine()) {
    String product = s.nextLine();
    System.out.println(String.valueOf(rowPrefix) + colPrefix + ": " + product);

    colPrefix++;
    if (colPrefix == NUM_COLUMNS) {
        colPrefix = 1;
        rowPrefix++;
    }
}