Payroll pay = new Payroll(EmployeeName, IDnumber);

//set pay rate and hours worked
pay.setHoursWorked(HoursWorked);
pay.setHourlyPayRate(HourlyPayRate);

//Get the Gross Pay of the employee.
System.out.println("The gross pay of " + EmployeeName + " is: " + pay.getGrossPay());