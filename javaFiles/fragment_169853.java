// This assumes you've renamed all the properties in Employee to be more
// sensible - there's no point in including the "employee" part - we already
// know we're calling a method on Employee
for (Employee employee : map.values())
{
    System.out.println("Employee Name:\t" + employee.getName());
    System.out.println("Employee Id:\t" + employee.getId());
    System.out.println("E-mail:\t "+ employee.getEmail());
}