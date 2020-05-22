@ManyToMany(
    targetEntity=package.CustomerCategory.class,
    cascade={CascadeType.PERSIST, CascadeType.MERGE}
)
@JoinTable(
    name="CustomerCategoryAdvertisements",
    joinColumns=@JoinColumn(name="AdvertisementId"),
    inverseJoinColumns=@JoinColumn(name="CustomerCategoryId")
)
private Set<Advertisement> advertisements;