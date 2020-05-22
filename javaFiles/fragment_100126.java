@Entity
@Table(schema = "test", name = "test")
public final class Test {

  private static final int ORIGINAL = 0;
  private static final int CURRENT = 1;

  private Integer id;

  // holds the original and current state of the field
  private final AtomicReferenceArray<String> field = new AtomicReferenceArray<>(2);

  @Id
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Transient
  public String getOriginalField() {
    return field.get(ORIGINAL);
  }

  @Basic
  public String getField() {
    return field.get(CURRENT);
  }

  public void setField(String field) {
    this.field.compareAndSet(ORIGINAL, null, field);
    this.field.set(CURRENT, field);
  }

  @PreUpdate
  public void preUpdate() {
    System.out.format("Original: %s, New: %s\n", getOriginalField(), getField());
  }

  ...