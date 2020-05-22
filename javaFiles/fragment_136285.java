for(counter=1; counter<=limit; counter++){
    System.out.println("\n\nEnter employee "+counter+" details\n");
    payroll.SetPayrollDetail();
    payroll.SetBonus();
    payroll.SetCommission();
    payroll.SetNssf();
    payroll.SetNetSalary();

}

for(counter=1; counter<=limit; counter++){
    payroll.GetPayroll();
    //System.out.println(a);
}