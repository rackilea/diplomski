@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

            String url = "http://someurl.com";
            WebView webview = (WebView) findViewById(R.id.webView);
            // next line explained below
            webview.setWebViewClient(new WebViewClient());
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl(url);
            new Thread(new Runnable() {
                @Override
                public void run() {
                                  try {
                                        newActivity();
                                  } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }

                        }
            }).start();    

}

void newActivity() throws InterruptedException {
    Thread.sleep(3000);
    Intent intent = new Intent(ShowPortalActivity.this, Inicio.class);
    startActivity(intent);
}

@Override
protected void onResume() {
    // TODO Auto-generated method stub
    super.onResume();   
}