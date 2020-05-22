public double calculateTax(Employee employee) {

    if (employee.getAnnualGrossSalary() < 41495){
        return employee.getAnnualGrossSalary()*0.16;
    }
    else if (employee.getAnnualGrossSalary() < 82985){
        return employee.getAnnualGrossSalary()*0.20;
    }
    else if(employee.getAnnualGrossSalary() < 100970){
        return employee.getAnnualGrossSalary()*0.24;
    }
    else
       return employee.getAnnualGrossSalary()*0.2575;
}