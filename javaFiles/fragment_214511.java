@args Employee employee

@ifNot(employee) {
    @return
}

Hello @employee.getFirstName()!