@XmlRootElement
public class MyResponse {

  private List<ItemListWrapper> items;

  //getters and setters
}

@XmlType
public class ItemListWrapper {

  private String key;
  private List<Item> items;

  @XmlAttribute
  public String getKey() {
    return this.key;
  }

  //rest of the getters and setters

}

@XmlType
public class Item {
  //just a bean
}