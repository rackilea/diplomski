@OneToOne
  @JoinColumns({
    @JoinColumn(name="id",
      referencedColumnName="id"),
    @JoinColumn(name="index",
      referencedColumnName="index"),
  })
  private Report report;
...