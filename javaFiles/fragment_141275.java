public class PageComment{

    private User user;

    public void setUserMadeBy(User aUser)
    {
        this.user = aUser;
    }

    public User getUserMadeTo()
    {
        return this.user;
    }
}