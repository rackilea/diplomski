@Column(name = "creation_time", nullable = false, updatable = false)
@CreatedDate
private LocalDateTime creationDate;

@Column(name = "modification_time", nullable = false, insertable = false)
@LastModifiedDate
private LocalDateTime modificationDate;