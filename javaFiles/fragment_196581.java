YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
        new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {
            }
        }).setApplicationName("video-test").build();

final String videoId = "Hl-zzrqQoSE";
YouTube.Videos.List videoRequest = youtube.videos().list("snippet,statistics,contentDetails");
videoRequest.setId(videoId);
videoRequest.setKey("{YOUR-API-KEY}");
VideoListResponse listResponse = videoRequest.execute();
List<Video> videoList = listResponse.getItems();

Video targetVideo = videoList.iterator().next();