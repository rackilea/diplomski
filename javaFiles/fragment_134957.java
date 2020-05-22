public Response deleteEmployee(Employee employee) {
    Status status;
    String reason = null;

    try {
        status = masterDao.deleteEmployeeDetails(employee);
    } catch (Exception e) {
        if (isConstraintViolationException(e)) {
            status = masterDao.deactivateEmployee(employee);
        } else {
            status = Status.ERROR;
            reason = "# EXCEPTION : " + e.getMessage();
        }
    }

    return buildResponse(status, reason);
}