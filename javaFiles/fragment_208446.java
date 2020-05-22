tile = 2;
for(i = 0; i < row; i = tile + i)
 for(j = 0; j < col; j= tile + j)
  for(r = 0; r < tile; r++)   
    for(c = 0; c < tile; c++) 
      System.out.print(" " + img[i+r][j+c]);
    System.out.print("\n");