interface CompanyRole { /* just a marker */ }

enum Google implements CompanyRole { 
    ...
    Employee.Builder<Google> builder(String name) {
        return new Employee.Builder<>(this, name);
    }
}

class Employee<T extends CompanyRole> { 
    ... 

    static class Builder<T extends CompanyRole> {
        EmployeeBuilder(T role, String name) { ... }
        Employee<T> build() { ... }
    }
}