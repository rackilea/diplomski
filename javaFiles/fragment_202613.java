Handler handler = new Handler ();
handler.postDelayed (new Runnable () {
     @Override
     public void run () {
          AdRequest bannerRequest = new AdRequest.Builder (). Build ();
          mAdView.loadAd (bannerRequest);
     }
}, 2000);