public class Test {

  // ... same code ...

  public static void main(String[] args) {
    String payload = "id=7&name=Pablo+Mat%C3%ADas&lastname=Gomez&githubUsername=pablomatiasgomez&" +
        "address.street=Coolsingel&address.number=42a&address.city=Rotterdam";
    User user = convert(payload, User.class);
    System.out.println(user);
  }
}

class User {

  long id;
  String name;
  String lastname;
  String githubUsername;
  Address address;

  @Override
  public String toString() {
    return "User{" +
        "\n  id=" + id +
        "\n  name='" + name + '\'' +
        "\n  lastname='" + lastname + '\'' +
        "\n  githubUsername='" + githubUsername + "'" +
        "\n  address=" + address + "\n" +
        '}';
  }
}

class Address {


  String street;
  String number;
  String city;

  @Override
  public String toString() {
    return "Address{" +
        "street='" + street + '\'' +
        ", number='" + number + '\'' +
        ", city='" + city + '\'' +
        '}';
  }
}