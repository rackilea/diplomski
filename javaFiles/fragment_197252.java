public class Comments extends BaseModel {

    private String can_post;

    @Override
    public String toString() {
        return "Comments [count=" + getCount() + ", can_post=" + can_post + "]";
    }
}