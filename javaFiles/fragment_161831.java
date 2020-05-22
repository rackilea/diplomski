int[][] array = {{1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
int counter = 0;

int rowLimit = array.length;
int colLimit = array[0].length;

for (int r = 0; r < rowLimit; r++)
{
  for (int c = 0; c < colLimit; c++)
  {
    if ((c+1 < colLimit) && (array[r][c] == array[r][c+1]))
      counter++;

    if ((r+1 < rowLimit) && (array[r][c] == array[r+1][c]))
      counter++;
  }
}