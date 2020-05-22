public Status deleteEmployeeDetails(Employee employee) {
    return Status.DELETE_SUCCESS; // or Status.DELETE_FAIL
}

public Status deactivateEmployee(Employee employee) {
    return Status.DEACTIVATE_SUCCESS; // or Status.DEACTIVATE_FAIL
}