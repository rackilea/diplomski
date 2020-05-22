public class contTest extends ActionSupport{
  public Employee  emp1;
  public String execute(){
    System.out.println("firstName-->>>"+emp1.getFirstName());
    System.out.println("lastName-->>>"+emp1.getLastName());
    return SUCCESS;
  }

  //Create Setter and Getter of emp1 object
}