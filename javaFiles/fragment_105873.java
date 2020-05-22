public class Attachment {
    private String ext;
    private int height;
    private String md5;
    private String name;
    private String ref;
    private boolean rotate;
    private int size;
    private String thumb;
    private int thumb_size;
    private String type;
    private int width;

}

public class Note {
    private String title;

    private Map<String, Attachment> attachment = new HashMap<>();
}