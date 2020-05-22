Collection<Employee> getEmployees() {
  final Collection<Employee> employees = new HashSet<Employee>();
  for (final Position2unit p2u : position2units) {
    employees.addAll(p2u.employees);
  }
  return employees;
}