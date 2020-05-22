public Employee create(String staffType) {
    Employee user = null;
    if (staffType.equals("E")) {
        user = new Employee();
    else if (staffType.equals("M")) {
        user = new Manager();
    }    
    ....
    return user;
}