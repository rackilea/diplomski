@Id
private Long id;

@JoinColumn(name = "Id")
@OneToOne
@MapsId
private Region region;