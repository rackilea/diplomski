public class MyDataResponse {

    @JsonProperty("video_link")
    private String videoLink;

    public MyDataResponse() {

    }

    public MyDataResponse(String videoLink) {
        this.videoLink = videoLink;
    }

    ...setters&getters
}