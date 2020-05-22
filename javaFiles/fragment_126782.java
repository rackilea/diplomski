ImageView img = (ImageView)findViewById(R.id.imageView1);
    img.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(View view)
        {       

            Intent intent = new Intent(Activity1.this,Activity2.class);
            intent.putExtra("urlString", "http://www.google.com");
            startActivity(intent);
        }
    });

    String url = getIntent().getExtras().getString("urlString");
    mWebView = (WebView) findViewById(R.id.webView1);
    mWebView.loadUrl(url);