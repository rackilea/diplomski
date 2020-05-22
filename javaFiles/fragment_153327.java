@ManyToMany(mappedBy = "following", cascade = CascadeType.ALL)
@JoinTable(name="UserRel", 
                joinColumns={@JoinColumn(name="ParentId")}, 
                inverseJoinColumns={@JoinColumn(name="UserId")})
private Set<User> followers = new HashSet<User>();

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name="UserRel", 
                joinColumns={@JoinColumn(name="UserId")}, 
                inverseJoinColumns={@JoinColumn(name="ParentId")})
private Set<User> following = new HashSet<User>();