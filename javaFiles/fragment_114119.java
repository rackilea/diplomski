for (int x = 0; x < N; x ++)
   for (int y = 0; y < N; y++) {
       thrd[threadCounter] = new Thread(new Threading(matA, matB, matC));
       thrd[threadCounter].start();
       thrd[threadCounter].join();
       threadCounter++;
   }