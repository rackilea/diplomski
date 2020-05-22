@Embeddable
public class user_groupId implements Serializable { 
    @Column(name="userId")
    private String userId;

    @Column(name="groupId")
    private String group;
}