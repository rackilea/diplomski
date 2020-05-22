FilterQuery fq = new FilterQuery();
  String keywords[] = {"sport", "politics", "health"}; //etc..

  fq.track(keywords);

  twitterStream.addListener(statusListener);
  twitterStream.filter(fq);