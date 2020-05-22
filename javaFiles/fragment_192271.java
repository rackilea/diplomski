for(int i =0; i < 5; i++){
    for(int j = 0; j < 9; j++){
       if(j==2*i || 8-2*i == j)
          System.out.print("*");
       else if(8-2*i < j && j > 2*i)
           break;
       else
          System.out.print("_");
    }
  System.out.println();
}