static class Address {
  Address(String name, String address, String address2, String phone) {
    this.name = name;
    this.address = address;
    this.address2 = address2;
    this.phone = phone;
  }

  String name;
  String address;
  String address2;
  String phone;

  public String toString() {
    return String.format("%s%n%s%n%s\nPhone: %s",
        name, address, address2, phone);
  }
}

public static void main(String[] args) {
  String name="Anna Brown";
  String address="1234 Sweet Road";
  String address2="Los Angeles, CA 99999";
  String phone="888.8888.888";
  System.out.print(new Address(name, address, address2, phone));
}