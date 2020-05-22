class Multi implements Runnable {
    final int N;
    final double [][] a;
    final double [][] b;
    final double [][] c;
    final int i;
    final int j;
    ...
    @Override
    public void run() {
        for(int k = 0; k < N; k++) c[i][j] += a[i][k] * b[k][j];
    }

}

ExecutorService pool = ...;
for (int i = 0;...)
    for (int j = 0;...)
     pool.submit(new Multi(N,i,j,a,b,c));

pool.shutdown();
pool.awaitTermination(1, TimeUnit.DAYS);