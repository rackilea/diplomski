public static void box(){
 int rows = 10;
 int columns = 10;  
 int number = (int) (Math.random() * 26) + 65;   // move this into loop 
 char[][] table = new char [rows][columns];
 for (int r = 0; r < rows; r++){
    for (int c = 0; c < columns; c++){
       table[r][c] = (char) number; 
       System.out.print(table[r][c] + " ");
    }//inner for loop
    System.out.println();
 }//outer for loop