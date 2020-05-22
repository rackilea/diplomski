rootview = inflater.inflate(R.layout.location_layout, container, false);
webView = (WebView)rootview.findViewById(R.id.webView);
WebSettings webSettings = webView.getSettings();
webSettings.setJavaScriptEnabled(true);
webView.loadUrl("URL HERE");
return rootview;
}