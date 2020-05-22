@ManyToOne
@JoinColumn(name = AbstractLocalizingEntity.COLUMN_RELATED_ENTITY, nullable = false)
private Product entity;

@Column(name = Product.COLUMN_DESCRIPTION, columnDefinition = "LONGTEXT")
private String description;