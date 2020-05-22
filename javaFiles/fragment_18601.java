Catalog catalog = new Catalog("BRIGHTCOVE MEDIA API TOKEN");
catalog.findVideoByID("1234567890", new VideoListener() {
  @Override
  public void onVideo(Video video) {
    videoView.add(video);
  }
  @Override
  public void onError(String error) {
    // Handle error
  }
});