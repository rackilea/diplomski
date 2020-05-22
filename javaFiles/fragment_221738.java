mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();

            }
             @Override
            public void onAdClosed() {
            Activity_Class_Name.this.finish();
        }

        @Override
        public void onAdOpened() {
            Activity_Class_Name.this.finish();
        }

        });