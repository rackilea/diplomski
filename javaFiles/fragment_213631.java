public class VideoResult {

    private int videos;
    private List<String> videoIds;

    public VideoResult(Document doc) {
        this.videos = doc.getInteger("videos");
        this.videoIds = (List<String>) doc.get("video_ids");
    }
  // getters and setters 
}