public class MainActivity extends Activity {
    //declared as class field, will be accessible in every method of the class
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise it here
        myWebView= (WebView) findViewById(R.id.webview);

        //rest of your code
}