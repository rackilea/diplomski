for (int i = 1; i <= n; i++ )
   {
      for (int j = 1; j < n; j++ )
        System.out.print(" ");

      n--;

      for (int k = i; k <=3*i-2; k++ )
          System.out.print(k%10);

      System.out.println("");
   }