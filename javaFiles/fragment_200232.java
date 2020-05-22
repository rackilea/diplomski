public class VideoSizeAdapter {

    @ToJson
    int[] toJson(VideoSize videoSize) {
        return new int[]{videoSize.width, videoSize.height};
    }

    @FromJson
    VideoSize fromJson(int[] dimensions) throws Exception {
        if (dimensions.length != 2) {
            throw new Exception("Expected 2 elements but was " + 
                Arrays.toString(dimensions));
        }
        int width = dimensions[0];
        int height = dimensions[1];
        return new VideoSize(width, height);
    }

}