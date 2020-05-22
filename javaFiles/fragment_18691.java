private long startTime;
private long finishedTime;

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                 startTime = System.nanoTime();

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                finishedTime = System.nanoTime();

                long timeToFullLoad = finishedTime - startTime; // It will be in NANO, just convert it to seconds and enjoy
            }