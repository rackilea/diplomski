public Optional<EmployeeDto> findById(String employeeId){
    Optional<EmployeeModel> employeeModel = employeeService.findById(employeeId);
    return employeeModel.map(this::toEmployeeDto);
}
private EmployeeDto toEmployeeDto(EmployeeModel employeeModel) {
    //employeeModel will not be null, so:
    //return EmployeeDto (convert EmployeeModel to dto)
}