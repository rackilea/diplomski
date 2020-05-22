for (int i = 0; i < employeeList.size(); i++)
{
    Employee emp = employeeList.get(i);
    System.out.println(emp);
    System.out.println(emp.getPay().CalcPayRate());
}