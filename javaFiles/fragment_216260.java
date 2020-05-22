List<Employee> retrieveEmployees(String searchToken, String fname, String lname, String type){
    List<Employee> employees = getEmployees();
    if(searchToken != null) {
        return employees
                .stream()
                .filter(emp -> emp.getFName().equalsIgnoreCase(searchToken) && emp.getLName().equalsIgnoreCase(searchToken))
                .collect(Collectors.toList());

    }
    Predicate<Employee> predicate = employee -> true;

    if(type != null) {
        predicate = predicate.and(emp -> emp.getType().equalsIgnoreCase(type));
    }
    if(lname != null) {
        predicate = predicate.and(emp -> emp.getLName().equalsIgnoreCase(lname));
    }
    if(fname != null) {
        predicate = predicate.and(emp -> emp.getFName().equalsIgnoreCase(fname));
    }

    return employees.stream()
             .filter(predicate)
             .collect(Collectors.toList());
}