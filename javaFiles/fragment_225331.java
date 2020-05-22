for (int j = 1; j < N; j++) {
       if (x[j] != x[j-1]) {
           count++;
       }
       System.out.println(count);
   }
   System.out.println(N-count);