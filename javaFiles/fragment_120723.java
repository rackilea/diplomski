@ManyToMany
@JoinTable(name = "USERS_GROUPS",
        joinColumns = {@JoinColumn(name = "USER_ID")},
        inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
@OrderBy("id ASC") //example
private List<Group> groups = new ArrayList<>();