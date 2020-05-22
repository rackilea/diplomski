// Role
@LazyCollection(LazyCollectionOption.FALSE)
@ManyToMany(mappedBy = "roles")
@JsonIgnoreProperties("roles")
@OrderBy("id")
private List<User> users;

// User
@LazyCollection(LazyCollectionOption.FALSE)
@ManyToMany
@JoinTable(name = "users_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
)
@JsonIgnoreProperties("users")
@OrderBy("id")
private List<Role> roles;