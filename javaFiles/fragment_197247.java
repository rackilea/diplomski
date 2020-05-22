public class Media {

    private String type;
    private String owner_id;
    private String item_id;
    private String thumb_src;
//setter getter here
        @Override
    public String toString() {
        return "Media [type=" + type + ", owner_id=" + owner_id + ", item_id="
                + item_id + ", thumb_src=" + thumb_src + "]";
    }
}