public class YourWebViewClient extends WebViewClient {
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            if (url.contains(".mp3")) {
                Log.d(TAG, "MP3 url = [" + url + "]");
            }
            return super.shouldInterceptRequest(view, request);
        }
}