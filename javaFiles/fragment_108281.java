int values = 0;
while (inFile.hasNext()) {
    String nextLine = inFile.nextLine();
    Scanner line = new Scanner(nextLine);
    while (line.hasNextInt()) {
        values = line.nextInt();
        //...
    }
}