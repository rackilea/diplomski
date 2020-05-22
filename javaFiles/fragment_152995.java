class Employee implements Comparable<Employee>
{
    String name;
    int age;
    @Override
    public int compareTo(Employee arg0) 
    {
        // sort first by name, then by age
        if(name.equals(arg0.name)) {
          return age - arg0.age;
        }
        return name.compareTo(arg0.name);
    }
    Employee( String nm, int a)
    {
        name =nm;
        age = a;
    }
    @Override
    public boolean equals(Object emp) {
       boolean result = false;
       if(emp != null && emp instanceof Employee) {
          Employee e = (Employee)emp;
          result = name.equals(e.name) && (age == e.age);
       }
       return result;
    }
}