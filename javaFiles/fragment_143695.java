int total;
int max = //This is the max number of column one row can have 
for (int col = 0; col < max; col++)
{
  total = 0;
  for (int row = 0; row < array.length; row++)
    if(col < array[row].length)//Check for row length here.
       total += array[row][col];
  System.out.println("Column " + col + " total: " + total);
}