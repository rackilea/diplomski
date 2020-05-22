@ManyToMany(
    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    mappedBy = "advertisements",
    targetEntity = Advertisement.class
)
private Set<CustomerCategory> customerCategories;
//getters and setters