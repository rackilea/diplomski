for (int i = 0;i<blocks.length;i++) //The output
{
    System.out.printf("%d: ", i);

    for (int j = 0;j<blocks[i].length;j++)
    {
     System.out.printf("%d", blocks[i][j]);

     if (i+1<blocks.length && j+1<blocks[i].length)
      System.out.printf(" ");
    }

      System.out.printf("\n");
}
}