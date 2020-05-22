public class FakeDTO implements BaseDTO {

  private AddressDTO address;

  public AddressDTO getAddress() {
    return address;
  }

  public void setAddress (AddressDTO address) {
    this.address = address;
  }
 ...
}

public class AddressDTO implements BaseDTO {

  private String zipcode;

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;

  }
 ...
}