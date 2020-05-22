@Override
    protected String getReportSpecifics() {
        return String.format("\n%s %s \n%s:$%,.2f",
                             "Base Salary Plus", getBaseSalaryPlus(),
                             "with Base Salary", getBaseSalary());
    }