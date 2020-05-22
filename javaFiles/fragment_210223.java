int[] vals = { 10, 34, 99, 1002, 40
      };
      for (int v : vals) {
         // the 07 means a field width of 7 with 0's padding on left.
         // th o means octal and the %n is newline.
         System.out.printf("%07o%n", v);
      }

      //This does the same thing but returns a formatted string.
      String paddedVal = String.format("%07o", 48);
      System.out.println(paddedVal);