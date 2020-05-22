@OneToMany
@JoinTable(
    name="User_Vehicle",
    joinColumns = @JoinColumn(name = "User_Id"),
    inverseJoinColumns = @JoinColumn(name = "Vehicle_Id")
)
Collection<Vehicle> vehicles = new ArrayList<>();