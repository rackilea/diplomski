public class GetShopifyJsonData extends GetRawData {
    public interface OnResultsReadyListener {
        void onResultsReady(List<Product> products);
    }

    private OnResultsReadyListener mResultsListener;

    public GetShopifyJsonData(int page, OnResultsReadyListener resultsListener) {
        super(null);
        createUri(page);
        mProduct = new ArrayList<Product>();
        mResultsListener = resultsListener;
    }

    public void processResults() {
        // Add this to the end of the method
        if(mResultsListener != null) {
            mResultsListener.onResultsReady(mProduct);
        }
    }
}