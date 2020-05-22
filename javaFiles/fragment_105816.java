@OneToMany(mappedBy="oepRole")
private List<OepUser> oepUsers;

@ManyToOne()
@JoinColumn(name="USER_ROLE_ID",nullable=false)
private OepRole oepRole;