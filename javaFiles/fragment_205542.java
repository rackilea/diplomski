@MappedSuperclass @Table("TABLE_1")
public class BadDBDesign {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column("table_id")
  private long key;

  @Column("small_value")
  private String smallVarChar2Field;
}