@ElementCollection
    @CollectionTable(name = "user_group", joinColumns = {
        @JoinColumn(name = "department", referencedColumnName = "department"),
        @JoinColumn(name = "groupid", referencedColumnName = "groupid")
    })
    @OrderColumn(name = "seq", nullable = false)
    private List<UserGroupMemberships> groupUsers = new ArrayList<>();