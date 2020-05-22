public abstract class DateMixin {
  @JsonDeserialize(using=com.test.jackson.DummyDateDeSerializer.class)
  public abstract Date getLastModifiedDate() ;
  @JsonDeserialize(using=com.test.jackson.DummyDateDeSerializer.class)
  public abstract Date getCreatedDate() ;
}