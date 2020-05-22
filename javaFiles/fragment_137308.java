public class Person {
  private String name;
  @JsonDeserialize(converter = AddressListConverter.class)
  private Map<String, AddressList> addresses;
  // ..
 }