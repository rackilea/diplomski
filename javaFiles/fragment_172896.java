adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                adView.setVisibility(View.GONE);
                adView.setVisibility(View.VISIBLE);
            }
        });