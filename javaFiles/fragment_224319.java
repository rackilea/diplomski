public void assignContractToEmployeeWithLeastContracts(Employee[] employees, Contract contract) {
    int minContract =  Arrays.stream(employees)
            .mapToInt(Employee::getCurrentlyAssignedContracts)
            .min()
            .getAsInt();
    List<Employee> minEmployees =  Arrays.stream(employees)
            .filter(e->e.getCurrentlyAssignedContracts() == minContract)
            .collect(Collectors.toList());

    Random r = new Random();
    Employee employeeWithMinContracts = minEmployees.get(r.nextInt(minEmployees.size()));

    employeeWithMinContracts.assignContract(employeeWithMinContracts, contract);
}