RelativeLayout layout = new RelativeLayout(this);
    RelativeLayout.LayoutParams gameViewParams =
            new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
    gameViewParams.bottomMargin = 150;

    View gameView = initializeForView(new MainGame(), cfg);
    layout.addView(gameView, gameViewParams);

    AdView adView = new AdView(this);
    adView.setAdUnitId("app-id");
    adView.setAdSize(AdSize.BANNER);

    RelativeLayout.LayoutParams adParams = 
        new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
                RelativeLayout.LayoutParams.WRAP_CONTENT);
    adParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
    adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

    layout.addView(adView, adParams);

    AdRequest adRequest = new AdRequest.Builder().build();
    adView.loadAd(adRequest);

    setContentView(layout);