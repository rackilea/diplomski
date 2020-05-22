public class WebViewFragment extends Fragment {
    public static final String TAG = WebViewFragment.class.getName();
    public WebView mWebView;

    ...  

    public void updateWebView(String url) {
        mWebView.loadUrl(url);
    }
}