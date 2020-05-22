@OneToMany
@JoinTable
(
    name="OBJECTA_OBJECTB",
    joinColumns={ @JoinColumn(name="ID", referencedColumnName="ID") },
    inverseJoinColumns={ @JoinColumn(name="OBJECTB_ID", referencedColumnName="ID") }
)
private List<ObjectB> objectList;