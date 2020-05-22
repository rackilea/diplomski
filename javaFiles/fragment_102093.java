if (employeeOneHours <= 40)
        {
            employeeOneTotalPay = employeeOneHours * employeeOneRate;
            System.out.printf("\nNormal time pay is: %.2f", employeeOneTotalPay);
        }
        else 
       {
            employeeOneNormalPay = employeeOneRate * 40;
        employeeOneTotalPayOverTime = (employeeOneHours - 40) * (employeeOneRate * overTimeRate) + employeeOneNormalPay;                            
        System.out.printf("\n\nTotal Pay including Overtime is: %.2f", employeeOneTotalPayOverTime);
}