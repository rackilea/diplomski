public class Driver {

private static final int N = 5;

public static void main(String args[]) throws InterruptedException, ExecutionException{
    int startId = 1;
    int endId = 1000;
    int range = (1 + endId - startId) / N;
    ExecutorService ex = Executors.newFixedThreadPool(N);
    List<Future<Integer>> futures = new ArrayList<Future<Integer>>(N);

    // submit all the N threads
    for (int i = startId; i < endId; i += range) {
        futures.add(ex.submit(new SumCallable(i, range+i-1)));
    }

    // get all the results
    int result = 0;
    for (int i = 0; i < futures.size(); i++) {
        result += futures.get(i).get();

    }
    System.out.println("Result of summing over everything is : " + result);

}

private static class SumCallable implements Callable<Integer> {

    private int from, to, count;
    private static int countInstance = 1;

    public SumCallable(int from, int to) {
        this.from = from;
        this.to = to;
        this.count = countInstance;
        System.out.println("Thread " + countInstance++ + " will use " + from + " to " + to);
    }

    // example implementation: sums over all integers between from and to, inclusive.
    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = from; i <= to; i++) {
            result += i;
        }
        System.out.println("Thread " + count + " got result : " + result);
        return result;
    }

}