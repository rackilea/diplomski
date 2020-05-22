EditText editText = (EditText) findViewById(R.id.UrlText);
editText.setOnEditorActionListener(new OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        boolean handled = false;
        //
        // test to see if the send button was pressed
        //
      if (actionId == EditorInfo.IME_ACTION_DONE) {
        //
        //  toast ouput for debugging
        //
            Context context = getApplicationContext();
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            handled = true;
            //
            // hide the keyboard
            //
            mIMEMgr.hideSoftInputFromWindow(findViewById(R.id.UrlText).getWindowToken(), 0);
            //
            // now, get the id of the webview
            //
            wv = (WebView) findViewById(R.id.webView1);
            //
            // define the methods to apply to the webview
            //
            WebSettings settings = wv.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setBuiltInZoomControls(true);
            //
            // apply the methods to the webview client
            //
            wv.setWebViewClient(new MyWebViewClient());
            //
            // condition the url sting
            //
            EditText et = (EditText) findViewById(R.id.UrlText);
            String url = et.getText().toString().trim();
            //
            // and now load the webpage
            //
            wv.loadUrl("http://" + url);

        }
        return handled;
    }
});