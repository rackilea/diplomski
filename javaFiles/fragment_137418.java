import java.io.Serializable;
public class Employee extends Person implements Serializable { //v2
  protected String address ;
  static final long serialVersionUID = 1L;

  public Employee()
  {
    super();
    address ="N/A";
  }

  public Employee(String name , int age, String address)
  {
    super(name,age);
    this.address = address;
  }

}