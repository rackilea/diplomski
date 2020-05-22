@XmlAccessorType(XmlAccessType.FIELD)
public static class MyField{

  Map<String, String> getSomeMap() {
      return someMap
  }

  void setSomeMap(Map<String, String> someMap) {
      this.someMap = someMap
  }

  //@XmlElement Remove this annotation
  private Map<String, String> someMap = new HashMap<String, String>()
}