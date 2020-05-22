public static int getNum() //Get amount of numbers to check
    {
      Scanner input = new Scanner ( System.in );
      System.out.print( "How many numbers would you like to test? " );
      int count = input.nextInt();
      int perfect = 1;
      boolean vN = validateNum(count, perfect);
      while(!vN ){
          System.out.println("Invalid input. Try again");
          count = input.nextInt();
          vN = validateNum(count, perfect);
      }
      return count;
    }