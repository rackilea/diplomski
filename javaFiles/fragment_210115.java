public void print_numbers(int num) {

      int counter = 1;

      while ( counter <= num ) {

          System.out.print(counter);
          if ( counter % 3 == 0 ) {
              System.out.print("\n");
          }
          counter++;
      }
}