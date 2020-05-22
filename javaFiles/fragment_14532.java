public class Employee {
   @Id
   private Key key;
   @Basic
   private String firstName;
   @Basic
   private String lastName;

   @Basic
   private String address1City;
   @Basic
   private String address1ZipCode;

   @Basic
   private String address2City;
   @Basic 
   private String address2ZipCode;
}