@Column(name = "countryid", insertable = false, updatable = false)
private Integer countryId;

@JoinColumn(name = "countryid", referencedColumnName = "countryid")
@ManyToOne
private Country country;