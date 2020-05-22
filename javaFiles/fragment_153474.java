@Override
public void onBackPressed() {
    // TODO Auto-generated method stub
    int currPage = mPager.getCurrentItem();
    WebView wv = null;
    switch (currPage) {
    case 0:
        wv = (WebView) mPager.getChildAt(currPage).findViewById(R.id.webView1);
        break;
    case 1:
        wv = (WebView) mPager.getChildAt(currPage).findViewById(R.id.webView2);
        break;
    case 2:
        wv = (WebView) mPager.getChildAt(currPage).findViewById(R.id.webView3);
        break;
    case 3:
        wv = (WebView) mPager.getChildAt(currPage).findViewById(R.id.webView4);
        break;
    }

    if (wv != null) {
        if (wv.canGoBack()) {
            wv.goBack();
        } else {
            super.onBackPressed();
        }
    } else {
        super.onBackPressed();
    }
}