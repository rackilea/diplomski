@Root
public class Entry {

  @Element
  private String trader;

  @Attribute
  private int id;

  public Entry() {
    super();
  }  

  public String getTrader() {
    return text;
  }

  public void setTrader(String trader) {
    this.trader = trader;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
}

@Root(name="root")
public class Entries {
   @ElementList(inline=true)
   List<Entry> entries;

   public Entries(List<Entry> entries) {
     this.entries = entries;
   }
}