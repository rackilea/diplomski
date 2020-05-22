WebView webView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    webView = (WebView)findViewById(R.id.WebView1);

    webView.getSettings().setJavaScriptEnabled(true);

    webView.setWebViewClient(new WebViewClient());

    registerForContextMenu(webView);

    webView.loadUrl(HTTP_URL);
}

@Override
public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo){
    super.onCreateContextMenu(contextMenu, view, contextMenuInfo);

    final WebView.HitTestResult webViewHitTestResult = webView.getHitTestResult();

    if (webViewHitTestResult.getType() == WebView.HitTestResult.IMAGE_TYPE ||
            webViewHitTestResult.getType() == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE) {

        contextMenu.setHeaderTitle("Download Image From Below");

        contextMenu.add(0, 1, 0, "Save - Download Image")
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        String DownloadImageURL = webViewHitTestResult.getExtra();

                        if(URLUtil.isValidUrl(DownloadImageURL)){

                            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadImageURL));
                            request.allowScanningByMediaScanner();
                            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                            DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                            downloadManager.enqueue(request);

                            Toast.makeText(MainActivity.this,"Image Downloaded Successfully.",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Sorry.. Something Went Wrong.",Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });
    }
}