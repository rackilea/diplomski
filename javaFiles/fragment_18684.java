//...
@ManyToMany
@JoinTable(name = "house_user_association", joinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")},
        inverseJoinColumns = {@JoinColumn(name = "house_id", referencedColumnName = "projectId")})
private Set<House> houses = new HashSet<>();
//...