SortedSet<Employee> subset = employees.tailSet(obj1);
for (Employee employee : subset) {
  if (employee.compareTo(obj6) < 0) {
    subset = subset.headSet(obj6);
    break;
  }
}