public class Wall {

    private int totalRecord;
    private Media media;
    private Attachment attachment;
    private List<Attachments> attachments;
    @SerializedName(value = "post_source")
    private PostSource postSource;
    private Comments comments;
    @SerializedName(value = "likes")
    private Like like;
    @SerializedName(value = "reposts")
    private Repost repost;

    private String id;
    private String from_id;
    private String to_id;
    private String date;
    private String post_type;
    private String text;
    private String can_delete;
    private String reply_count;
    private String online;

        // setter getter here
}