public List<Employee> getEmployees() {
    return addressList.stream()
            .map(address ->
             new Employee(name, age, Arrays.asList(address), salary))
            .collect(Collectors.toList());
}