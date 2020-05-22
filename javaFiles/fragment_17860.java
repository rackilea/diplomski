public class UserInformation
{
    private String username;
    private int gender;

    public UserInformation(String username, int gender)
    {
        this.username = username;
        this.gender = gender;
    }

    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public int getGender()
    {
        return gender;
    }
    public void setGender(int gender)
    {
        this.gender = gender;
    }
}