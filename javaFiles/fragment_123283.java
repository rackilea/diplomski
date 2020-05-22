@Configuration
@PropertySource(name = "props", value = "classpath:teddy.properties", ignoreResourceNotFound = false)
@ConfigurationProperties(prefix = "teddy")
public class TeddyBearConfig {

  private List<TeddyBear> list;

  public List<TeddyBear> getList() {
    return list;
  }

  public void setList(List<TeddyBear> list) {
    this.list = list;
  }

  public static class TeddyBear {
    private String name;
    private String price;

    public TeddyBear() {

    }

    public TeddyBear(String name, String price) {
      this.name = name;
      this.price = price;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPrice() {
      return price;
    }

    public void setPrice(String price) {
      this.price = price;
    }
  }
}