@Override
public String toString() {
    return String
            .format("\nSalesman Name: %s, Monthly Salary=$%,.2f,Annual Sales=$%,.2f,Annual Salary=$%,.2f",
                    getEmployeeName(), getMonthlySalary(), getAnnualSales(), annualSalary());
}