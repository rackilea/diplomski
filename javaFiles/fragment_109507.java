String fileName = "Sudoku2d.txt";
Scanner inputStream = null;
String[] line;
System.out.println("The file " + fileName + "\ncontains the following lines:\n");
inputStream = new Scanner(new File("C:\\Users\\username\\Documents\\NetBeansProjects\\Sudoku\\Sudoku2d.txt"));
int[][] puzzel = new int[9][9];
int row = 0;
while (inputStream.hasNextLine()) {
    line = inputStream.nextLine().split(",");
    for (int i = 0; i < 9; i++) {
        puzzel[row][i] = Integer.parseInt(line[i]);
    }
    row++;
}