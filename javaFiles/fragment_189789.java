final AppBarLayout appBar = findViewById(R.id.testeparainfo);
final RealtimeBlurView blurView = findViewById(R.id.blurView);
blurView.setAlpha(1F);
appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
    @Override
    public void onOffsetChanged(final AppBarLayout appBarLayout, final int verticalOffset) {
        float offsetAlpha = (appBarLayout.getY() / appBar.getTotalScrollRange());
        blurView.setAlpha(offsetAlpha * -1);
    }
});