webView.getSettings().setJavaScriptEnabled(true);
  webView.addJavascriptInterface(new WebAppInterface(this),
                   "Android");

public class WebAppInterface {
    Context mContext;
    /** Instantiate the interface and set the context */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /** Hide image view */
    @JavascriptInterface
    public void hideImageView() {
        imageView.setVisibilty(View.GONE);
     }  
    }