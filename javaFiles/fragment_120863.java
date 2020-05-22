@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)  
@JoinTable(name = "flower_store_emp_vehicle", 
           schema = "dbo", 
           catalog = "tyler", 
           inverseJoinColumns = { @JoinColumn(name = "vehicle_id", nullable = false, updatable = false) }, 
           joinColumns = { @JoinColumn(name = "employee_id", nullable = false, updatable = false) })
private Set<Vehicle> vehicles;