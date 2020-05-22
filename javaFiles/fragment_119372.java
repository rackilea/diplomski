public class MainActivity extends AppCompatActivity {

    private final Handler uiHandler = new Handler();
    private ArrayAdapter<String> adapter;
    private ArrayList<String> entries = new ArrayList<>();
    private ProgressDialog progressDialog;

    private class JSHtmlInterface {
        @android.webkit.JavascriptInterface
        public void showHTML(String html) {
            final String htmlContent = html;

            uiHandler.post(
                new Runnable() {
                    @Override
                    public void run() {
                        Document doc = Jsoup.parse(htmlContent);
                        Elements elements = doc.select("#online_movies > div > div");
                        entries.clear();
                        for (Element element : elements) {
                            String title = element.select("div.l-description.float-left > div:nth-child(1) > a").first().attr("title");
                            String imgUrl = element.select("div.l-image.float-left > a > img.lazy").first().attr("data-original");
                            entries.add(title + "\n" + imgUrl);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }
            );
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, entries);
        listView.setAdapter(adapter);

        progressDialog = ProgressDialog.show(this, "Loading","Please wait...", true);
        progressDialog.setCancelable(false);

        try {
            final WebView browser = new WebView(this);
            browser.setVisibility(View.INVISIBLE);
            browser.setLayerType(View.LAYER_TYPE_NONE,null);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.getSettings().setBlockNetworkImage(true);
            browser.getSettings().setDomStorageEnabled(false);
            browser.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            browser.getSettings().setLoadsImagesAutomatically(false);
            browser.getSettings().setGeolocationEnabled(false);
            browser.getSettings().setSupportZoom(false);

            browser.addJavascriptInterface(new JSHtmlInterface(), "JSBridge");

            browser.setWebViewClient(
                new WebViewClient() {

                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        progressDialog.show();
                        super.onPageStarted(view, url, favicon);
                    }

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        browser.loadUrl("javascript:window.JSBridge.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                        progressDialog.dismiss();
                    }
                }
            );

            findViewById(R.id.buttonDown).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    uiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            int page = Integer.parseInt(browser.getUrl().split("-")[1]);
                            int newPage = page > 1 ? page-1 : 1;
                            browser.loadUrl("http://srulad.com/#page-" + newPage);
                            browser.loadUrl(browser.getUrl()); // not sure why this is needed, but doesn't update without it on my device
                            if(getSupportActionBar()!=null) getSupportActionBar().setTitle(browser.getUrl());
                        }
                    });
                }
            });

            findViewById(R.id.buttonUp).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    uiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            int page = Integer.parseInt(browser.getUrl().split("-")[1]);
                            int newPage = page+1;
                            browser.loadUrl("http://srulad.com/#page-" + newPage);
                            browser.loadUrl(browser.getUrl()); // not sure why this is needed, but doesn't update without it on my device
                            if(getSupportActionBar()!=null) getSupportActionBar().setTitle(browser.getUrl());
                        }
                    });
                }
            });

            browser.loadUrl("http://srulad.com/#page-1");
            if(getSupportActionBar()!=null) getSupportActionBar().setTitle(browser.getUrl());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}