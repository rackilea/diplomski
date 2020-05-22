public class Restaurant {

  private String name;
  private String tel;

  public Restaurant(String name, String tel) {
    this.name = name;
    this.tel = tel;
  }

  /*getters and setters*/

  override public boolean equals(Object obj) {
    if(obj instanceOf Restaurant) {
      Restaurant that = (Restaurant) obj;
      return (this.name.equals(that.getName()) && this.tel.equals(that.getTel()));
    } else {
      return false;
    }
  }
}