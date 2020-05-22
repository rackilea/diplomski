@ManyToOne(fetch = FetchType.LAZY)
@JoinColumns({
  @JoinColumn(name = "entity2_id", insertable = false, updatable = false),
  @JoinColumn(name = "entity2_type", insertable = false, updatable = false)
})
private Entity2 entity2;