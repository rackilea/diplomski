public class OrderWorker<I extends OfferType> implements Callable<OrderWorker<I>> {
    ...
    @Override
    public OrderWorker<I> call() throws Exception {
        ...
    }
}