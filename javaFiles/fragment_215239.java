/// Create a AdView
AdView myAdView = new AdView(MY_ACTIVITY);
myAdView.setAdUnitId(<ADMOB ID>);
myAdView.setAdSize(AdSize.SMART_BANNER);

/// Set the initial frame
FrameLayout.LayoutParams initialFrm = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, 
                                                                   FrameLayout.LayoutParams.WRAP_CONTENT, 
                                                                   Gravity.CENTER_HORIZONTAL | Gravity.TOP); 
MY_ACTIVITY.addContentView(myAdView, initialFrm);

/// ....

/// Now whenever I want to position it on the bottom I do this:
myAdView.setLayoutParams(new FrameLayout.LayoutParams(
                         FrameLayout.LayoutParams.WRAP_CONTENT, 
                         FrameLayout.LayoutParams.WRAP_CONTENT, 
                         Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM));

/// To put it back on the top, do this:
myAdView.setLayoutParams(new FrameLayout.LayoutParams(
                         FrameLayout.LayoutParams.WRAP_CONTENT, 
                         FrameLayout.LayoutParams.WRAP_CONTENT, 
                         Gravity.CENTER_HORIZONTAL | Gravity.TOP));