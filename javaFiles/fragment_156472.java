for (int i = 200; i > 0; i--) {
        int j = i
         System.out.print(i + ", ");

         while (j > 4) {

            if (j % 2 == 0) {
               int i1 = j / 2;
               System.out.print(i1 + ", ");
               j = i1;

            }
            else {
               int i1 = j * 3 + 1;
               System.out.print(i1 + ", ");
               j = i1;
            }
         }
         System.out.println(" ");

      }