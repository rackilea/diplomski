//parent class
public abstract class Customer {
 private String Name, Address, Phone, Email, Company;
 public static final int NAME = 0, ADDRESS = 1, PHONE = 2, EMAIL = 3, COMPANY = 4;

 public Customer(String Name, String Address, String Phone, String Email, String Company) {
     setValues(Name, Address, Phone, Email, Company);
 }

 private void setValues(String Name, String Address, String Phone, String Email, String Company) {
     setName(Name);
     setAddress(Address);
     setPhone(Phone);
     setEmail(Email);
     setCompany(Company);
 }

 public String getName() {
   return Name;
 }

 public String getAddress() {
   return Address;
 }

 //etc....

}