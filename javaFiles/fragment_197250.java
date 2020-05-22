public class Photo {

    private String pid;
    private String aid;
    private String owner_id;
    private String src;
    private String src_big;
    private String src_small;
    private String src_xbig;
    private String width;
    private String height;
    private String text;
    private String created;
    private String access_key;
// setter getter here
    @Override
    public String toString() {
        return "Photo [pid=" + pid + ", aid=" + aid + ", owner_id=" + owner_id
                + ", src=" + src + ", src_big=" + src_big + ", src_small="
                + src_small + ", src_xbig=" + src_xbig + ", width=" + width
                + ", height=" + height + ", text=" + text + ", created="
                + created + ", access_key=" + access_key + "]";
    }

}