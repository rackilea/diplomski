int count = 0;
      for (int n : list) {
         System.out.printf("%4d ", n);
         if (++count % 10 == 0) {
            System.out.println();
         }
      }
   }