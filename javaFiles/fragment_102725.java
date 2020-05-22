for (int i = 0; i < newArray.length; i++) {
     for (int j = 0; j < newArray.length; j++) {
         if(j == 0) System.out.printf("%3d",newArray[i][j]);
         else System.out.printf(" %3d",newArray[i][j]);
     }
     System.out.println();
}