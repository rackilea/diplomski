public class Repost extends BaseModel {

    private String user_reposted;

    @Override
    public String toString() {
        return "Repost [user_reposted=" + user_reposted + ", count=" + getCount() + "]";
    }
}