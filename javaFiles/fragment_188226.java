@Column(name = "OBJREF", nullable = false)
private String otherObjectId;

@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name = "OBJREF", nullable=false, updatable=false, insertable=false)
private OtherObject otherObject;