@Named
@SessionScoped
public class EmployeeController implements Serializable {

  //using CDI @Inject annotation empService will be initialized automatically
  @Inject
  private EmployeeService empService;

  //this method can be called from .xhtml page
  public String obtainEmployeeName(Long id) {
    String empName = "";
    Employee emp = empService.findEmployeeById(id);
    if (emp != null) {
      empName = emp.getName();
    }
    return empName;
  }
}