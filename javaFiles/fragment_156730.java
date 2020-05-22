public static void main(String[] args) {
    int[] A ={01,11,111};
    int B[] = new int[A.length];
    for(int i=0;i<A.length;i++){
        B[i]=getDigitSum(A[i]);
    }
     int E = 11;
    int K= getDigitSum(E);
    int N =B.length;
    Arrays.sort(B);
    int DP[][] = new int[B.length][B[B.length-1]+1];


    for (int i=0;i<N;i++) {
        DP[i][B[i]] = 1;

        if (i == 0) continue;

        for (int k=0;k<K;k++) {
            DP[i][k] += DP[i - 1][k];
        }
        for (int k=0;k<K;k++) {
            if( k + B[i] >= K) break ;
            DP[i][k + B[i]] += DP[i - 1][k];
        }
    }
    int sum=0;
    for(int i=0;i<K;i++) {
        sum = sum +DP[N-1][i];
    }
    int result = ((int)Math.pow(2,N)) - sum-1;
    System.out.println(result);

}

private static int getDigitSum(int num) {
    int sum =0;
    while(num >0){
       sum=sum+ (num%10);
        num= num/10;
    }
    return sum;
}