switchButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        }

    });

     WebView myWebView = (WebView) findViewById(R.id.webView1);
     myWebView.loadUrl("https://www.google.com/");