@Valid
@OneToOne(cascade = CascadeType.ALL, 
            fetch = FetchType.EAGER, 
            optional = false)
@JoinColumn(name = "address_id")
private Address address;