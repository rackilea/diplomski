Collections.sort(listEmployees , new Comparator<listEmployees >() {
    @Override
    public int compare(EmployeeModelCls lhs, EmployeeModelCls rhs) {
        if (rhs.getAge() - lhs.getAge() == 0)
            return rhs.getSalary() - lhs.getSalary();

        return (rhs.getAge() - lhs.getAge());
    }
});