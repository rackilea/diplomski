@JavascriptInterface
public void gotoSite() {
    //Toast.makeText(mContext, url, Toast.LENGTH_SHORT).show();
    webC.clearCache(true);//Here you call the methond in other thread
    webC.loadUrl("http://google.com");
}