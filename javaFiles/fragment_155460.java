myWebView.setWebChromeClient(new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (newProgress == 100) {
                view.post(new Runnable() {

                    @Override
                    public void run() {
                        // take the snapshot here


                    }
                });

            }
        }

    });