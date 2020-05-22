@Entity
public class MyEntity {

  @Column(name="col_a")
  private String colA;

  @Column(name="col_b")
  private String colB;

  @Formula("concat(col_a, col_b)")
  private String concated;

  //...
}