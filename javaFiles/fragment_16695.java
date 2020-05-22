@Entity
class A {

  @Id
  @Column
  public String id;

  @Column
  public String notes;

  @org.hibernate.annotations.OptimisticLock(excluded = true)
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "A_B",
      joinColumns = { @JoinColumn(name = "A_ID") },
      inverseJoinColumns = { @JoinColumn(name = "B_ID") })
  public Set<B> bDomains;

  @Version
  public int version;
}