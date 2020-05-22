Scanner input = new Scanner(System.in)
      int value = 0;
      while (true) {
         System.out.print("Please enter a value between 1 and 12: ");
         value = input.nextInt();
         if (value >= 1 && value <= 12) {
            break;
         }
         System.out.println("That is not within the range!");
      }
      // now do something with value.