// in Company POJO:
@OneToOne(mappedBy="company", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
private CompanyDetails companyDetails

// in CompanyDetails POJO:
@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
@JoinColumn(name="company_id")  
public Company company;