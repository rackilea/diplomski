feedService.loadVideoDetailsFeed(things)
               .flatMap(new Func1<List<VideoDetails>, Observable<List<Video>>>() {
                   @Override
                   public Observable<List<Video>> call(final List<VideoDetails> videoDeets) {
                       return Observable.from(videoDeets).map(new Func1<VideoDetails, Video>() {
                           @Override
                           public Video call(final VideoDetails videoDetails) {
                               return videoDetails.getVideo();
                           }
                       }).toList();
                   }
               })
               .map(new Func1<List<Video>, VideoGrid>() {
                   @Override
                   public VideoGrid call(List<Video> videos) {
                       return VideoGrid.fromListOfVideos(videos);
                   }
               });