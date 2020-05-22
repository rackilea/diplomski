@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "user_project_role",
        joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
@WhereJoinTable(clause = "role_id=7")
@SQLInsert(sql = "insert into user_project_role (project_id, user_id, role_id) values (?, ?, 7)")
@SQLDelete(sql = "delete from user_project_role where project_id=? and user_id=? and role_id = 7")
@Setter(AccessLevel.NONE)
private Set<User> projectLeaders = new HashSet<>();

@ManyToMany
@JoinTable(name = "user_project_role",
        joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
@LazyCollection(LazyCollectionOption.EXTRA)
@WhereJoinTable(clause = "role_id=8")
@SQLInsert(sql = "insert into user_project_role (project_id, user_id, role_id) values (?, ?, 8)")
@Setter(AccessLevel.NONE)
private Set<User> projectUsers = new HashSet<>();