int startRow = max(row - 1, 0);
int endRow = min(row + 1, width - 1);

int startCol = max(col - 1, 0);
int endCol = min(col + 1, height - 1);

for (int r = startRow; r <= endRow; r++)
   for (int c = startCol; c <= endCol; c++)
       if (r != row || c != col) //it looks like you want to skip this cell
           ray[r][c] += 1;