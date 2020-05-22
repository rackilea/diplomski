@OneToMany(fetch=FetchType.LAZY)
@JoinTable
(
      name="USER_PROFILE",
      joinColumns={ @JoinColumn(name="USER_ID", referencedColumnName="ID")},
      inverseJoinColumns={ @JoinColumn(name="PROFILE_ID", referencedColumnName="ID")}
)
private List<Profile> profileList;