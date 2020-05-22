int totalRow = 5;
char[][] myArray = new char[totalRow][];
File file = new File("test.txt");
Scanner scanner = new Scanner(file);

for (int row = 0; scanner.hasNextLine() && row < totalRow; row++) {
    myArray[row] = scanner.nextLine().toCharArray();
}