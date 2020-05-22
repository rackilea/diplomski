...
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties("_type")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "_type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = Cancel.class, name = "_type"),
  @JsonSubTypes.Type(value = Fail.class, name = "_type"),
  @JsonSubTypes.Type(value = Success.class, name = "_type"),
})
public abstract class AbstractModel {
  private String userId;

  private Type type;

  AbstractModel() { }

  AbstractModel(final String userId, final Type type) {
    this.userId = userId;
    this.type = type;
  }

  // getters, toString, etc.

  public enum Type {
    CANCEL("event.cancelled"),
    FAIL("event.failed"),
    SUCCESS("event.success");

    private final String value;

    Type(String value) {
      this.value = value;
    }

    public String getValue() { return value; }
  }
}