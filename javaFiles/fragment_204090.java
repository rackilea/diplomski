import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "content_type")
@JsonSubTypes({
  @JsonSubTypes.Type(name = "typeA", value = ScheduledAContent.class),
  @JsonSubTypes.Type(name = "typeB", value = ScheduledBContent.class)
})
public abstract class ScheduledContent {
  private String someField;

  @JsonSetter("some_field")
  public void setSomeField(String someField) {
    this.someField = someField;
  }

  public abstract void doSomethingWithContent();
}