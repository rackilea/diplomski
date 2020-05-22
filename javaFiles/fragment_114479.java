@Column(name="CREATED_DATE", updatable = false)
private java.sql.Timestamp createdDate = new java.sql.Timestamp(System.currentTimeMillis());

@Version
@Column(name="MODIFIED_DATE")
private java.sql.Timestamp modifiedDate;