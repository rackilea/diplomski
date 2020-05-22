private static double computeGrossPay(Employee employee)
{
    if (employee.hoursWorked <= 40)
    {
        employee.grossPay = (employee.hoursWorked * payRate);
    } else if (hoursWorked >= 40)
    {
        employee.grossPay = ((40 * payRate) + ((1.5 * payRate) * (employee.hoursWorked - 40)));
    }
    return employee.grossPay;
}