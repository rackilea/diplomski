public MDArray(String file)
{
    Scanner input = null;
    try {
        input = new Scanner(new FileInputStream("ragged.txt"));
    }
    catch (FileNotFoundException e) {
        System.out.println("File Not Found.");
        System.exit(0);
    }
    rowCount = input.nextInt(); 
    mdarray = new double[rowCount][]; // init the array
    for(int i = 0; i < rowCount; i++) {
        columnCount = input.nextInt();
        mdarray[i] = new double[columnCount]; // init the current row
        for(int j = 0; j < columnCount; j++) {
            mdarray[i][j] = input.nextDouble();
        }
    }

}