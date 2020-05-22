for (int lines = 3; lines >= 1; lines--)
     {
         if (lines == 3) 
            System.out.printf("%1s", " ");
         else if (lines == 2)
            System.out.printf("%2s", " ");
         else if (lines == 1)
            System.out.printf("%3s", " ");

         for (int stars = 1; stars <=  2* lines - 1; stars++)
            System.out.print('*');

         System.out.println();
      }