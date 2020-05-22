public class Address {
  @OneToOne (mappedBy="address")  //<- not "student"
  private Student student; 
}  

public class Student {
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="ADDRESS_ID")
  private Address address; //<- this maps the association and thus is the value for the corresponding mappedBy
}