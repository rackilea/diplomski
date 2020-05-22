new Handler(Looper.getMainLooper()).post(new Runnable() {
        @Override
        public void run() {
            browser.loadUrl(url2);
        }
    });