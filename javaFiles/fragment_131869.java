private static Func1<VideoDetails, Video> _getVideo = new Func1<VideoDetails, Video>() {
    @Override
    public Video call(final VideoDetails videoDetails) {
        return videoDetails.getVideo();
    }
};
private static Func1<List<VideoDetails>, Observable<List<Video>>> _mapVideoDetailsToVideos = new Func1<List<VideoDetails>, Observable<List<Video>>>() {
    @Override
    public Observable<List<Video>> call(final List<VideoDetails> videoDeets) {
        return Observable.from(videoDeets).map(_getVideo).toList();
    }
};
private static Func1<List<Video>, VideoGrid> _buildVideoGridFromVideos = new Func1<List<Video>, VideoGrid>() {
    @Override
    public VideoGrid call(List<Video> videos) {
        return VideoGrid.fromListOfVideos(videos);
    }
};

private static void yourFunction(final VideoDeetsSource feedService, String things) {
    feedService.loadVideoDetailsFeed(things)
               .flatMap(_mapVideoDetailsToVideos)
               .map(_buildVideoGridFromVideos);
}