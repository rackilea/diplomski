@Entity
    @Table(name = "user_sessions")
    @JsonIgnoreProperties( { "userID" })
    public class UserSession{

    @Column(name="uid")
    private Long userID;
    @Id
    @Column(name="access_key")
    private String accessKey;
    @Column(name="secret_key")
    private String secretKey;

    public Long getUserID() {
    return userID;
    }

    public void setUserID(Long s) {
        this.userID = s;
    }`