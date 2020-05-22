for( int i = 0; i < N; i++) {
       final int p = i;
       new Thread(new Runnable() {
             public void run() {
                  for(int a = p*(M/N);a < (p+1)*(M/N); a++)
                  System.out.println("Thread "+p+":"+array[a]);
             }
        }).start();
     }