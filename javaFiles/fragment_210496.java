private class CustomWebViewClient extends WebViewClient {
        @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
              if(url.contains("google.com")) {
                view.loadUrl(url);
              } else {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
              }
              return true;
            }
        }