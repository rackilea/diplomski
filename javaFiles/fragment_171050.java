public class Office
{
   private final List<Employee> employees = new LinkedList<>(); //or ArrayList

   public Office()
   {
      // do nothing
   }

   // FYI variables should start with a lowercase character
   public void addOffice(String name, String jobTitle, int age, int salary)
   {
      Employee e = new Employee(employees.size(), name, jobTitle, age, salary);
      employees.add(e);
   }
}