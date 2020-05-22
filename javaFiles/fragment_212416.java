@Entity
@Table(name="UserProfile")
public class UserProfile implements Serializable {

    private long uProfileId;
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uProfileId", nullable = false, unique = true)
    public long getUProfileId() {
        return uProfileId;
    }

    public void setUProfileId(long uProfileId) {
        this.uProfileId = uProfileId;
    }

    @OneToOne
    @PrimaryKeyJoinColumn(name="profile_user_fk")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    ...
}