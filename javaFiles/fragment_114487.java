@Entity
class Y {
  @Id
  int id;

  @ManyToOne
  @JoinColumn(name = "x_id")
  X x;

  @Column(name = "x_id", insertable = false, updatable = false, nullable = false)
  int xId;
}