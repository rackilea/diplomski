web_view = (WebView) view.findViewById(R.id.web_view);
web_view.getSettings().setJavaScriptEnabled(true);
web_view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //your_key is your javaScript key
                final String videoUrl = url.replace("your_key:", "");

                Intent intent=new Intent(getContext(), VideoPlayerActivity.class);
                intent.putExtra("url",videoUrl);
                startActivity(intent);
                return false;
            }
        });
web_view.loadUrl(yourUrl);