String savedGameFile = /*...*/;
int[][] board = new int[9][9];
BufferedReader reader = new BufferedReader(new FileReader(savedGameFile));
String line = "";
int row = 0;
while((line = reader.readLine()) != null)
{
   String[] cols = line.split(","); //note that if you have used space as separator you have to split on " "
   int col = 0;
   for(String  c : cols)
   {
      board[row][col] = Integer.parseInt(c);
      col++;
   }
   row++;
}
reader.close();