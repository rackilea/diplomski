public static void checkDiagonal(int[][] array){

     // Start with the assumption that both diagonals are consistent.
     boolean majorConsistent = true; 
     boolean minorConsistent = true;

     int length = array.length;

     int tempMajor = array[0][0];        // all elements in the Major must be equal to this
     int tempMinor = array[0][length-1]; // all elements in the Minor must be equal to this

     // Check major diagonal, and update the boolean if our assumption is wrong.
     for(int i=0; i<length; i++){ 
         if (array[i][i] != tempMajor) { //(0,0);(1,1);(3,3);...
             majorConsistent = false;
             break;
         }
     }

     // Check minor diagonal, and update the boolean if our assumption is wrong.
     for(int i=0,j=length-1; i<length; i++,j--){
         if (array[i][j] != tempMinor) { //(0,7);(1,6);(2,5);...
             minorConsistent = false;
             break;
         }
     }

     System.out.println("Major elements all same = "+majorConsistent);
     System.out.println("Minor elements all same = "+minorConsistent);

 }