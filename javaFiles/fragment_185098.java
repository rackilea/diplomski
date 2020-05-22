int[][] board = new int[9][9];
BufferedReader br = new BufferedReader(new FileReader(new File("/path/to/file")));
String line;
int lineNumber = 0;
while ((line = br.readLine()) != null) {
    String[] numbers = line.split("");
    for (int columnNumber = 0; columnNumber < numbers.length; columnNumber++)
        board[lineNumber][columnNumber] = Integer.parseInt(numbers[columnNumber]);
    lineNumber++;
}
br.close();