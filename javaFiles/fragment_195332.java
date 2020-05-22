@Entity
public class A {

  @Id
  @GeneratedValue
  @Column(name = "aId")
  private Long id;

  @OneToOne(fetch = FetchType.LAZY, optional=false, cascade = CascadeType.ALL, mappedBy = "a")
  private B b;
  ... 
} 


@Entity
@org.hibernate.annotations.GenericGenerator(name="a-primarykey", strategy="foreign", parameters={@org.hibernate.annotations.Parameter(name="property", value="a")})
public class B {

  @Id
  @GeneratedValue(generator = "a-primarykey")
  @Column(name = "aId")
  private Long id;

  @OneToOne
  @PrimaryKeyJoinColumn
  private A a;
  ...
}