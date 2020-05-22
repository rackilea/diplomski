runOnUiThread(new Runnable() {
        @Override public void run() {
            if (interstitial.isLoaded()) {
              interstitial.show();
         }
        }
    });