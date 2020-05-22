YouTubePlayer youTubePlayer;

public void onCreate() {
  super.onCreate();

  // initialize player here and save 
  // ...
  @Override
  public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
     this.youTubePlayer = youTubePlayer;
  }

}


// in your listener
mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
      String videoID = urlList.get(i).toString();
      this.youTubePlayer.loadVideo(videoID);
  }
}