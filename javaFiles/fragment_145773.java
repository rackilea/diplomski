public static void drawCircle (int radius, int cx, int cy, char symbol){
  verifyInput(radius,cx,cy);

  //set the values for extension of the axes (aka how long are they)
  int xMax = cx+radius+1;
  int yMax = cy+radius+1;

 for(int j=yMax; j>=0; j--){
   for(int i=0; i<=xMax; i++){

  //set of if-block to print the axes
  if (i == 0 && j == 0){
    System.out.print('+');
    continue;
  }
  else if(i == 0){
    if (j == yMax){
      System.out.print('^'); 
    }  
    if(j != yMax && onCircle(radius,cx,cy,i,j)==false){
      System.out.print('|');
      continue;
    }
  }

  else if(j == 0){
    if(i == xMax){
      System.out.print('>');
    }
    if(i != xMax && onCircle(radius,cx,cy,i,j) == false){
      System.out.print('-');
      continue;
    }
  }

  //if block to print the circle
  //verify for each coordinate (i,j) in the quadrant if they are on circle
  //if =true print symbol, if =false print empty character
  if(onCircle(radius,cx,cy,i,j)==true){
    System.out.print(symbol);
  }
  else{
    System.out.print(' ');
  }

}
System.out.println();

}  
}