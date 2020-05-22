public class UsersDataFromFirebase {
    private String userName;
    private String userEmail;
    private ImageView userImage;

    public UsersDataFromFirebase() {
        // empty default constructor, necessary for Firebase to be able to deserialize blog posts
    }

    public String getUserName() { return userName; }

    public String getUserEmail() { return userEmail; }

    @JsonIgnore    
    public ImageView getUserImage() { return userImage; }
}