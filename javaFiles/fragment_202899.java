public class CustomPageImpl<T> extends PageImpl<T>{
@JsonProperty("contacts")
public List<T> getContent() {
  return super.getContent();
}
}