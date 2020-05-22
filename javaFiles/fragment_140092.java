public class Sample{
  public Sample()
  {

  }
  @SerializedName("Name")//if needed
  String name;
  @SerializedName("Email")//if needed
  String email;
  public void set(String name) {
        this.name = name;
    }

  public String getName() {
        return name;
    }
  public void set(String email) {
        this.email = email;
    }

  public String getEmail() {
        return email;
    }
}