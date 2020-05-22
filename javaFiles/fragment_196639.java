CountDownLatch countDownLatch;

public ThreadSum(int first, int end, int[] array, AtomicInteger result, CountDownLatch countDownLatch) {
    this.first = first;
    this.end = end;
    this.array = array;
    this.result = result;
    this.countDownLatch = countDownLatch;
}
@Override
public void run() {
    int sum = 0;
    System.out.println(currentThread().getName());
    for(int i = first; i < end; ++i) {
        sum += array[i];
    }
    countDownLatch.countDown();
    result.getAndAdd(sum);
}