public class Volume {
  private String status; 
  private Boolean managed; 
  private String name; 
  private Support support; 
  private String storage_pool; 
  private String id; 
  private int size;
  private List<String> mapped_wwpns;

  public String getId(){return id;}
  public String getName(){return name;}
}