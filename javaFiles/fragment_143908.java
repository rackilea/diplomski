webview.getSettings().setJavaScriptEnabled(true);
if(videoPath!=null && isValidUrl(videoPath)
{
mWebView.setVisibility(View.VISIBLE); 
webview.loadData(html, "text/html", null);
    }

else
webview.setVisibility(View.GONE);