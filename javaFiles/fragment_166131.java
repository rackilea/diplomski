protected void onResume() {
        // TODO Auto-generated method stub
        adView.setAdListener(new AdListener() {
            @Override
              public void onAdOpened() {
                // Save app state before going to the ad overlay.
              }

            @Override
            public void onAdClosed() {
                adView.setVisibility(View.GONE);
                // TODO Auto-generated method stub
                super.onAdClosed();
            }

        });


        super.onResume();
}