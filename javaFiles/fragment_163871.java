public class User{
   ...

   @XmlElement(name = "street")
   public String setStreet(String street) {
       this.org.setStreet(street);
   }
}