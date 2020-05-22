@Entity
@Table(name="testuserrole")
public class UserRole{
    @EmbeddedId
    private UserRoleId id = new UserRoleId();

    public UserRoleId getId() {
        return id;
    }

    public void setId(UserRoleId id) {
        this.id = id;
    }

    @Transient
    public long getUserId() {
        return id.userId;
    }

    public void setUserId(long userId) {
        id.userId=userId;
    }

    @Transient
    public long getRoleId() {
        return id.roleId;
    }

    public void setRoleId(long roleId) {
        id.roleId=roleId;
    }

}

@Embeddable
class UserRoleId implements Serializable {

    @Column(name = "user_id")
    public long userId;

    @Column(name = "role_id")
    public long roleId;

}