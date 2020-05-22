public List<Employee> retrieveEmployees(String searchToken, String fname, String lname, String type){
    List<Employee> employees = getEmployees();
    SearchFilter searchFilter = new SearchFilter(searchToken, fname, lname, type);

    Optional<Predicate<Employee>> firstCondition = conditions.stream()
            .filter(condition -> condition.getSearchFilterPredicate().test(searchFilter))
            .findFirst()
            .map(condition -> condition.getFunction().apply(searchFilter));

    return firstCondition.map(employeePredicate -> employees.stream()
                .filter(employeePredicate)
                .collect(Collectors.toList()))
            .orElse(employees);
}