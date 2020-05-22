// request the progress-bar feature for the activity
getWindow().requestFeature(Window.FEATURE_PROGRESS);

// set a webChromeClient to track progress    
myWebView.setWebChromeClient(new WebChromeClient()
{
 public void onProgressChanged(WebView view, int progress)
 {
   // update the progressBar
   MyActivity.this.setProgress(progress * 100);
 }
});