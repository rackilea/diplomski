public class JavascriptInterfaceActivity extends Activity {
    /** Called when the activity is first created. */


    WebView wv;

    JavaScriptInterface JSInterface;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        wv = (WebView)findViewById(R.id.webView1);

        wv.getSettings().setJavaScriptEnabled(true);
        // register class containing methods to be exposed to JavaScript

        JSInterface = new JavaScriptInterface(this);
        wv.addJavascriptInterface(JSInterface, "JSInterface"); 

       if(not_logged_in){
         wv.loadUrl("file:///android_asset/myPage.html");
       }


    }


    public class JavaScriptInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        JavaScriptInterface(Context c) {
            mContext = c;
        }

        @android.webkit.JavascriptInterface
        public void login_success()
        {
            // save login success.
        }
    }
}