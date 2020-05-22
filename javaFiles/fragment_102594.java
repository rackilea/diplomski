@JsonIgnoreProperties(ignoreUnknown=true)
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class OQScoresRows {
  private int id;
  private int active;
  private String name;
  private Object value;