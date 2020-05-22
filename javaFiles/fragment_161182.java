@Entity
@Table(name = "my_class_table")
public class MyClass {
  private String aliasId;

  private Point2D.Double field;

  public Point2D.Double getField() {
    return field;
  }

  public void setField(Point2D.Double field) {
    this.field = field;
  }

  public String getAliasId() {
    return aliasId;
  }

  public void setAliasId(String aliasId) {
    this.aliasId = aliasId;
  }
}