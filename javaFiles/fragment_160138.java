AdRegistration.setAppKey("APPKEY");
AdRegistration.enableTesting(test);
adView = new AdLayout(UnityPlayer.currentActivity);
LinearLayout layout = new LinearLayout(UnityPlayer.currentActivity.getApplicationContext());
layout.setGravity(Gravity.BOTTOM);
UnityPlayer.currentActivity.addContentView(layout, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
layout.addView(adView, new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT,
LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL));