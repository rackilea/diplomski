public class FlowableTest {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        Flowable.range(0, 10_000).onBackpressureBuffer(1, () -> {
        }, BackpressureOverflowStrategy.DROP_OLDEST).observeOn(Schedulers.computation()).subscribe(it -> {
            System.out.println(it);
            Thread.sleep(5);
        });

        Thread.sleep(50000); // wait the main program sufficient time to let the other threads end

    }