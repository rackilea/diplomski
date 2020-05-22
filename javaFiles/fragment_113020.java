int POST_DELAY_TIME = 2000;
m_WebView_Search.postDelayed(new Runnable() {
    @Override
    public void run() {
        m_WebView_Search.startAnimation(mWSE);
    }
}, POST_DELAY_TIME);