adView.loadAd(adRequest);
    adView.setAdListener(new AdListener() {
        public void onAdLoaded() {
            View parent = (View) adView.getParent(); 
            if (parent != null) {
                if (!(parent.equals(layout) || parent.equals(linear_layout))) { 
                    if (inLayout)
                        layout.addView(adView); 
                    else
                        linear_layout.addView(adView,0); // adding it to linearLayout first element, that's what the zero does
                    recalculateScreen();
                }
            } else {
                //add new banner ad to screen
                if (inLayout)
                    layout.addView(adView);// same here
                else
                    linear_layout.addView(adView,0); //same here, goes to the top
                recalculateScreen();
            }
        }
    });
}