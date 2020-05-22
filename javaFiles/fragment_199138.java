@ManyToMany(fetch=FetchType.LAZY) // don't use EAGER unless you really want to :)
@JoinTable(name="profile_activities",
    joinColumns={ @JoinColumn(name="profile_id") },
    inverseJoinColumns = { @JoinColumn(name="interest_id") } )
@OrderColumn(name="display_order")
private Set<Interest> activities;

//GETTER AND SETTERS AS FOR interests