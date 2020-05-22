1. for (int j = 0; j < sorted[0].length; j++)
  {

2.     for (int i = 0; i < sorted.length - 1; i++) 
     {

3.        double currentMin = sorted[i][j];
3.        int minIndex = i;

4.        for (int row = i + 1; row < sorted.length; row++)
        {

5.           if (currentMin > sorted[row][j]) 
           {
              currentMin = sorted[row][j];
              minIndex = row;
           }
        }
6.        if (minIndex != i) 
        {
           sorted[minIndex][j] = sorted[i][j];
           sorted[i][j] = currentMin;
        }

     }
  }
  return sorted;
}