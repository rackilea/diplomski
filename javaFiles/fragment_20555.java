public class View_Fav_PDF extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_fav_pdf);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("FavURL");
        query.selectKeys(Arrays.asList("URL"));
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> posts, ParseException e) {

                if (e == null) {
                    List<String> postTexts = new ArrayList<>();
                    for(ParseObject post : posts){
                        postTexts.add(post.getString("URL"));

                        WebView webView = (WebView) findViewById(R.id.webview);
                        webView.getSettings().setJavaScriptEnabled(true);
                        webView.getSettings().setLoadWithOverviewMode(true);
                        webView.getSettings().setUseWideViewPort(true);

                        webView.loadUrl(
                                post.getString("URL"));
                    }

                    Toast.makeText(View_Fav_PDF.this, postTexts.toString(), Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(View_Fav_PDF.this, "query error: " + e, Toast.LENGTH_LONG).show();

                }
            }
        });
    }