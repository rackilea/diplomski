FrameLayout fLayout = new FrameLayout(this);

FrameLayout.LayoutParams fParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT);

admobView = createAdView();

View gameView = createGameView(config);
    fLayout.addView(gameView);
    fLayout.addView(admobView);
    setContentView(fLayout);
    startAdvertising(admobView);