@Override
    public void onPause() {
        **if (adView != null) adView.pause();**
        super.onPause();
        CCDirector.sharedDirector().pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        CCDirector.sharedDirector().resume();
        **if (adView != null) adView.resume();**
    }