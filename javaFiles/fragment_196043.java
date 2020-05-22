@EmbeddedId
protected PersonHomePk personHomePk;
@Column (name = "type")
private String type; 
@JoinColumn(name = "person_id", referencedColumnName = "person_id", insertable = false, updatable = false)
@ManyToOne(optional = false)
private Person person;