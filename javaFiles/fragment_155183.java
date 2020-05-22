private int salary;

public void setSalary(int newSalary) {
    if (newSalary < MAX_SALARY) {
        this.salary = newSalary;
    } else {
        this.salary = MAX_SALARY;
    }
}