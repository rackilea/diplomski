enum DesignationLevel {
    SOFTWARE_ENGINEER, SENIOR_SOFTWARE_ENGINEER, MANAGER;
}

class Designation {
    DesignationLevel designationLevel;
    List<Responsibility> responsibilities;
}

class Employee {
    Designation designation;
    Employee manager;
    List<Employee> subordinates;
}