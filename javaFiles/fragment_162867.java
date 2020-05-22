public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    int maxn=0, maxSize=0;
    for(int n=N; n>0; n--) {
        int size = collatz(n);
        if(size>maxSize) {
            maxn = n;
            maxSize = size;
        }
    }
    System.out.println(maxn + " - " + maxSize);
}