public class MediaProcessor implements Runnable {
    private final List<String> absoluteMediaPath;
    private final String mediaType;

    public MediaProcessor(List<String> absoluteMediaPathList, String mediaType) {
       this.absoluteMediaPath = new ArrayList(absoluteMediaPathList);
       this.mediaType = mediaType;
    }

    @Override
    public void run() {
        if (mediaType.equals(MediaType.PHOTO)) {
            for (String mediaPath : absoluteMediaPath) {
                ...
            }
        }
    }
}

...

Thread thread = new Thread(new MediaProcessor(listMediaPath, mediaType));
thread.start();