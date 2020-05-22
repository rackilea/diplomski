import org.springframework.stereotype.Component;

@Component
public class Departments {
   private List<Department> department;

   public List<Department> getDepartment() {
    return department;
   }

   public void setDepartment(List<Department> department) {
    this.department = department;
   }

}