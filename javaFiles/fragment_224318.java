public void assignContractToEmployeeWithLeastContracts(Employee[] employees, Contract contract) {
    int minContract =  Arrays.stream(employees)
            .mapToInt(Employee::getCurrentlyAssignedContracts)
            .min()
            .getAsInt();
    Employee employeeWithMinContracts = Arrays.stream(employees)
            .filter(e->e.getCurrentlyAssignedContracts() == minContract)
            .findAny()
            .get();

    employeeWithMinContracts.assignContract(employeeWithMinContracts, contract);
}