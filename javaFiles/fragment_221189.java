// On Customer class:

@OneToOne(optional=false)
@JoinColumn(
    name="CUSTREC_ID", unique=true, nullable=false, updatable=false)
public CustomerRecord getCustomerRecord() { return customerRecord; }

// On CustomerRecord class:

@OneToOne(optional=false, mappedBy="customerRecord")
public Customer getCustomer() { return customer; }