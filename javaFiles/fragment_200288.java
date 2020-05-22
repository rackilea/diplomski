@Service
public class HeavyLiftingServiceImpl implements IHeavyLiftingService {

    public ListenableFuture<String> heavyLifting() {
        AsyncRestTemplate asycTemp = new AsyncRestTemplate();
        ListenableFuture<String> future = asycTemp.execute(url, method, requestCallback, responseExtractor, urlVariable);

        ListenableFutureAdapter<String, String> chainedFuture;
        chainedFuture = new ListenableFutureAdapter<String, String>(future) {

            @Override
            protected String adapt(String adapteeResult)
                    throws ExecutionException {
                        String parsedString = parse(adapteeResult);
                        return adapteeResult;
            }
        };

        return chainedFuture;
    }

}