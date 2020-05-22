public class A {
  ...
  @ManyToOne(fetch = FetchType.EAGER) // EAGER forces outer join
  @JoinColumn(name = "a_id")
  @Where(clause = "a_id = id or a_id is null") // "id" is A's PK... modify as needed
  public B getB() { return b; }

}

public class B {
  ...
  @OneToMany(mappedBy = "b")
  public List<A> getA() { return a; }
}