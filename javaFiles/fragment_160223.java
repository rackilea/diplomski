public class Selector {

  private enum DepartmentCategory = {
    Wind("A"),
    Air("B"),
    Fire("C"),
    Cloud("C"),
    River("C"),
    Tree("D"),
    Abc("D"),
    Def("E");

    private String department;

    DepartmentCategory(String department) {
      this.department = department;
    }
    public String getDepartment() {
      return department;
    }
  };
}