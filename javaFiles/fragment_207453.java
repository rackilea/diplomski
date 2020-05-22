public static BigInteger fib(BigInteger n) {
    if (n.compareTo(BigInteger.ONE) == -1 || n.compareTo(BigInteger.ONE) == 0 ) return n;
    else 
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.ONE).subtract(BigInteger.ONE)));
}

public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int j = 0; j < 10; j++) {
        final int ID = j;
        executorService.submit(new Runnable() {

            public void run() {
                for (int i=0;i < Integer.MAX_VALUE; i++) {
                    System.out.println(ID+" worker: "+i + ": " + fib(new BigInteger(String.valueOf(i))));
                }
            }
        });
    }        
}