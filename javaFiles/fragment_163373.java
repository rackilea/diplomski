@Override
protected void onResume() {
    super.onResume();
    playerView.initialize(KEY, this);
}

 @Override
    public void onStop() {
   if (player != null) {
            player.release();
        }
        player = null;
        super.onStop();
    }