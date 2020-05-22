public class Like extends BaseModel {

    private int user_likes;
    private String can_like;
    private String can_publish;

    @Override
    public String toString() {
        return "Like [user_likes=" + user_likes + ", can_like=" + can_like
                + ", can_publish=" + can_publish + ", count =" + getCount()
                + "]";
    }
}