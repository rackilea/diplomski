Twitter twitter = TwitterFactory.getSingleton();
List < Status > statuses = twitter.getHomeTimeline();

for (Status status: statuses) {
 ExtendedMediaEntity[] extendedMediaEntities = status.getExtendedMediaEntities();

 for (ExtendedMediaEntity eme: extendedMediaEntities) {
  if (eme.getMediaURLHttps() != null) { //also check blank
   if (eme.getType.equals("photo"))
    twitterImage.add(me.getMediaURLHttps());
  }
 }
}