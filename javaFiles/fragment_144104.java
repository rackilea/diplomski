@Id
@Column(name = "USER_ID", unique = true, nullable = false)
private int addressId;


@MapsId
@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
private User user;