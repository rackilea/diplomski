public class Department {
    String name;
    String description;
    //have to query other Table to get headOfDepartment
    Employee headOfDepartment;
    //have to query other table to get members
    List<Employee_Ids> members;
    //have to query other table to get subDepartments.
    List<Department_Ids> subDepartments;
}