@Version
@org.hibernate.annotations.Source(SourceType.DB)
@org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
@Column(name = "row_version") //maybe unnecessary, because this annotation
                              //is only needed, if the column name does not
                              //match hibernate's default naming strategy
                              //(or custom strategy).
@Temporal(TemporalType.TIMESTAMP)
private Date rowVersion;