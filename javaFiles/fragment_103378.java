holder.webView.setWebViewClient(new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            if (url != null && url.startsWith("http://"))
            {
                view.getContext().startActivity(
                    new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
            }
            else
            {
                Log.e("URL: ", url);
                System.out.println(url.replace(url.substring(0, url.lastIndexOf("/") + 1), ""));
                // Start your app's Activity here
            }

            return true;
        }
    });