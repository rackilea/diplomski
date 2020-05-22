@JavascriptInterface
public void gotoSite() {
    //Toast.makeText(mContext, url, Toast.LENGTH_SHORT).show();

    new Handler().post(new Runnable() {
        @Override
        public void run() {
            webC.clearCache(true);//Here you call the methond in UI thread
            webC.loadUrl("http://google.com");
        }
    });

}