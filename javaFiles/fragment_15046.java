public class InfoPage extends AppCompatActivity
{
    WebView webview;
    String product_id,product_tile;
    protected void onCreate(Bundle savedInstanceState) 
    {

      super.onCreate(savedInstanceState);
      setContentView(R.layout.product_info_xml);
      product_id=getIntent().getStringExtra("prod_id");
      product_tile=getIntent().getStringExtra("prod_title");
      getSupportActionBar().setTitle(product_tile);
      webview=findViewbyID(R.id.myWebView);
      webview.loadUrl("http://www.YourProductUrl.com");
    }
}