public class MainActivity extends AppCompatActivity {

public WebView myWeb;
public Button myBtn;
public EditText myEdit;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    myWeb = findViewById(R.id.webView);
    myBtn = findViewById(R.id.myButton);
    myEdit = findViewById(R.id.search_for);

    myEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                final String myText = myEdit.getText().toString();
                myWeb.loadUrl("http://www.google.com/search?q=" + myText);
                return true;
            }
            return false;
        }
    });



    myBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String myText = myEdit.getText().toString();
            myWeb.loadUrl("http://www.google.com/search?q=" + myText);
        }
    });



    myWeb.getSettings().setJavaScriptEnabled(true);
    myWeb.setWebChromeClient(new WebChromeClient());
    myWeb.setWebViewClient(new WebViewClient());
    myWeb.loadUrl("https://www.google.com");


}}