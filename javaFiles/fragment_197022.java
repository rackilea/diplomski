//array need numbers from 1 to 15(Can be populated with a loop)
    int[] colm = { 1, 2, 3, 4, 5, 14, 15}; //Enter 1 to 15
    int[] colm2 = {16,17,18,19,20,21,22,30};//...16 to 30
    int[][] board = new int[5][5];
 //...
    List l = new ArrayList();
    for(int i: colm)
        l.add(i);

    Collections.shuffle(l);

    for (int i = 0; i < 5; i++)
       for (int j = 0; j < 5; j++)
      if(i=0) board[i][j] = colm1[j]
      if(i=1) board[i][j] = colm2[j]
    //...

        }
     }