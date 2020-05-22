protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.your_layout_xml);
     ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
     CustomWebView webView = new CustomWebView(this, viewFlipper);
     // TODO: Add webView to viewFlipper
 }