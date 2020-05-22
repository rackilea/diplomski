public class MainActivity extends Activity
        implements GetShopifyJsonData.OnResultsReadyListener {
    private List<Product> allproducts;

    @Override
    void onResultsReady(List<Product> products) {
        // allProducts contains products for all requests that have completed so far
        allProducts.addAll(products);
        Log.v(LOG_TAG, allProducts.size() + " total products downloaded.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allProducts = new ArrayList<>();

        for (int i=1; i<6; i++) {
            GetShopifyJsonData jsonData = new GetShopifyJsonData(i, this);
            jsonData.execute();
        }
    }
}