void print(){

       int[][] array = {
                         {3, 2, 1, 0, -1},
                         {9, 7,11 ,12, 13, 14},
                         {15, 16, 17, 18, 19},
                         {20, 21, 22, 23, 24}
                       } ;
       for(int i=0;i<array.length;i++) {
           System.out.print("block "+ (i+1)+" ");//Prints the block number
           for(int j=0;j<array[i].length;j++) {
               if(array[i][j] <= 0) {
                   break; 
                   //Goes to the next iteration of outer for loop.
               }
               else {
                   System.out.print(array[i][j]+" ");
               }
           }
           System.out.println();
       }
}