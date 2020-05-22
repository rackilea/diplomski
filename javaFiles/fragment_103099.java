@Id
@Basic(optional = false)
@Column(name = "A_ID")
@SequenceGenerator( name = "mySeq", sequenceName = "MY_SEQ", allocationSize = 1, initialValue = 1 )
@GeneratedValue(strategy=GenerationType.IDENTITY, generator="mySeq")
private BigDecimal aId;