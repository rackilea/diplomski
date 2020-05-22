public class HUB extends Fragment {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {


    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_hub, container, false);

    final ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.pBar);

    WebView mWebView = (WebView) rootView.findViewById(R.id.webview);
    mWebView.setWebChromeClient(new WebChromeClient(){
    // SSL error handler
    });

    mWebView.setWebViewClient(new WebViewClient(){

        public void onProgressChanged(WebView view, int progress){
            if(progress < 100 && progressBar.getVisibility() == ProgressBar.GONE){
                progressBar.setVisibility(ProgressBar.VISIBLE);
            }

            progressBar.setProgress(progress);
            if(progress == 100){
                progressBar.setVisibility(ProgressBar.GONE);
            }
        }
    });
    mWebView.clearCache(true);
    mWebView.clearHistory();
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.getSettings().setDomStorageEnabled(true);
    mWebView.loadUrl("https:10.10.1.40/index.html");
    return rootView;
}