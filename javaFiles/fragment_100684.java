class Bar {

  @Id
  private String barId;

  @ElementCollection(targetClass = BigDecimal.class, fetch = FetchType.EAGER )
  @JoinTable(name="Foo", joinColumns = @JoinColumn(name = "barId"))
  @MapKeyColumn(name = "columnA")
  @Column(name = "columnB")
  private Map<String, BigDecimal> fooMap;

  ...
}