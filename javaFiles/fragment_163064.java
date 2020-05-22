@ManyToMany
@JoinTable(name = "PARENT_TO_CHILD_LINK_TABLE",
           joinColumns = @JoinColumn(name = "PARENT_ID"),
           inverseJoinColumns = @JoinColumn(name = "CHILD_ID"))
private List<Person> children;

@ManyToMany(mappedBy = "children")
private List<Person> parents;