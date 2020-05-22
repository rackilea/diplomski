public class Employee {
   @Id
   private Key key;
   @Basic
   private String firstName;
   @Basic
   private String lastName;

   @OneToMany
   private List<Address> addresses;

   @Basic
   private List<String> cities;

   /**
    * Same goes for removeAddress...
    */
   public void addAddress(Address address) {
      addresses.add(address);
      cities.add(address.city);
   }
}