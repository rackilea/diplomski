@ManyToMany(mappedBy="permissions")
@JoinTable(name="tblUserPermission",
 joinColumns={@JoinColumn(name="permissionId", referencedColumnName="permissionId")},
 inverseJoinColumns={
 @JoinColumn(name="username", referencedColumnName="username"),                         
 @JoinColumn(name="countyId", referencedColumnName="countyId")})
private Collection<User> users;