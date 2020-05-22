@Then("^following list of employees are returned$")
public void following_list_of_employees_are_returned(List<Employee> expectedEmployees) throws Throwable {    
  List<Map<String, Object>> actualEmployees = new ArrayList<>();
  List<Employee> employees = response.as(Employee[].class);
  assertEquals(expectedEmployees, actualEmployees);
}