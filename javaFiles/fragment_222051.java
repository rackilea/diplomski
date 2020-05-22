interface EmployeeVisitor {
    void visitEmployee(Employee employee);
}

class CleanUpEmployee implements EmployeeVisitor {
    void visitEmployee(Employee employee) {
        ...
    }
}

class Employee {
    void accept(EmployeeVisitor visitor) {
        visitor.visitEmployee(this);
    }
}