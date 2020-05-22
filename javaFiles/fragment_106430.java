@ManyToOne
@JoinTable(name="PersonAddress", 
    joinColumns=@JoinColumn(name="addressId"),
    inverseJoinColumns=@JoinColumn(name="personId")
)
private Person person;