@Id
@GeneratedValue(generator = "foreignGenerator")
@org.hibernate.annotations.GenericGenerator(name = "foreignGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "atData"))
@Column(name = "ACT_AT_ID")
private long actvAtId;

@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name = "ACT_AT_ID",insertable=false,updatable=false)
private AtData atData;
// getters, setters