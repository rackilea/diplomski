int minContract = Integer.MAX_VALUE;
Employee empMin = null;
for (Employee employee : employees) {
    if (employee.getNumberOfCurrentlyAssignedContracts() < minContract) {
        // swap min and employee if true
        empMin = employee;
        minContract = empMin.getNumberOfCurrentlyAssignedContracts();
    }
}