@Entity
class Foo {
  @Id
  int id;

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="MOO_ID")
  Moo moo;
}