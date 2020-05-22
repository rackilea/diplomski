public class GroupUser implements Serializable {
    private String id;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Group groupId;
    private Date dateCreated;
    private String createdBy;
}