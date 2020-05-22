@OneToMany(targetEntity = Owner.class, cascade = { CascadeType.ALL, CascadeType.MERGE }, fetch = FetchType.LAZY)
@JoinTable(name = "PRODUCT_OWNER", 
       joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, 
       inverseJoinColumns = { @JoinColumn(name = "OWNER_ID") })
@OrderColumn(name="DISPLAY_ORDER")
private List<Owner> productOwners = new HashSet<Owner>(0);