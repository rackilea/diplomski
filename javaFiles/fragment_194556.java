@XmlRootElement(name = "counting")
public class Count {

  private List<Value> value;

  public Count() {}

  // Getters and setters 
  @XmlElement
  public List<Value> getValue() {
    return value;
  }

  public void setValue(List<Value> value) {
    return this.value = value;
  }        
}

@XmlAccessorType(XmlAccessorType.FIELD)
public class Value {

  public Value() {}

  @XmlAttribute
  private long id;

  @XmlAttribute
  private String name;

  @XmlAttribute
  private String date; 

  @XmlValue
  private String xmlValue; 

  // Getters and setters  
}