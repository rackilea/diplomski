int n = input.nextInt();
    Random rand = new Random();
    int [][] A = new int[2][n];
    for (int i = 0; i<n; i++) {
       A[0][i] = i+1;
       A[1][i] = rand.nextInt(10);
    }