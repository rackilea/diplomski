@Entity
    @Table(name = "user_sessions")
    public class UserSession{

    @Column(name="uid")
    private Long userID;
    @Id
    @Column(name="access_key")
    private String accessKey;
    @Column(name="secret_key")
    private String secretKey;
    @JsonIgnore
    public Long getUserID() {
    return userID;
    }

    public void setUserID(Long s) {
        this.userID = s;
    }`