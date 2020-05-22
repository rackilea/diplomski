long value = Long.MAX_VALUE;

      System.out.println(value);

      while (value != 0) {
         // get the remainder when divided by 10
         int digit = (int) (value % 10);
         System.out.print(digit + " ");
         // now divide value by 10 to position for next digit.
         value /= 10;
      }
      System.out.println();