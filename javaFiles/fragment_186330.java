public class User {
    @Column(name = "ACCESS_GROUP")
    private Integer group;

    @OneToMany
    @JoinColumn(name = "ACCESS_GROUP", referencedColumnName = "ACCESS_GROUP",
        insertable = false, updateable = false)
    private List<Access> accessList;
    ...
}

public class Access {
    @Column(name = "ACCESS_GROUP")
    private Integer group;

    @OneToMany
    @JoinColumn(name = "ACCESS_GROUP", referencedColumnName = "ACCESS_GROUP",
        insertable = false, updateable = false)
    private List<User> userList;
    ...
}