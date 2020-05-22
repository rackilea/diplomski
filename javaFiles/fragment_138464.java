int row = 0 , column = 0;
  if(inputFile.hasNextInt())
    row= inputFile.nextInt();
  if(inputFile.hasNextInt())
    column = inputFile.nextInt();
  int [][] array=new int [row][column];
  System.out.println("This array has "+row+" rows and "+column+" columns");
  for (int i=0;i<row; i++){
     for (int j=0; j<column; j++){
       if(inputFile.hasNextInt())
           array[i][j] = inputFile.nextInt();
       System.out.println(array[i][j]);
     }
  }