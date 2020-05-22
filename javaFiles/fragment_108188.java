public static void main(String[] args) {
    //display a title at top 
    System.out.printf ("Value        Square          Cube\n");

    //display numbers 1-20 
    for(int i=0; i<20; i++){
      int square = i * i;
      int cube = i * i * i;

      System.out.printf("%-14d %-14d %-14d \n", 
           i,  square, cube);
    }
}