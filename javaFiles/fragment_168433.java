public class AddressSubType extend Value {

  public static final AddressSubType DOM = new AddressSubType("DOM");
  public static final AddressSubType INTL = new AddressSubType("intl");
  ...

  private AddressSubType(String keyword) {
     super(keyword);
  }
}