private VideoFeedView primaryVideoFeed;

private void initUI() {
   primaryVideoFeed.registerLiveVideo(VideoFeeder.getInstance().getPrimaryVideoFeed(),true);
   startStreaming();

}