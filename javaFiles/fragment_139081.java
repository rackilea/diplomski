for (int i = 0;i<blocks.length;i++) //The output
{
    System.out.printf("%d : ", i);  //// Here was the 1st Problem

    for (int j = 0;j<blocks[i].length;j++)
    {
     System.out.printf("%d", blocks[i][j]);

     if (i+1<blocks.length && j+1<blocks[i].length)
      System.out.printf(" ");
    }
    if (i+1<blocks.length)         ////Here was the 2nd Problem
      System.out.printf("\n");
}