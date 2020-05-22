@JavascriptInterface
        public void changeTest(){

            Log.d("TEST", "THIS IS THE BIGGEST TEST EVER");

            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    myWebView.loadUrl("http://google.it");
                }
            });
        }