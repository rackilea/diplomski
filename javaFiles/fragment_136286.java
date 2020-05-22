payroll2[] PayrollList = new payroll2[limit];  // establish the array with correct size
for(counter=0; counter<=limit - 1; counter++){  // bounds of the array are 0 to limit - 1
    payroll = new payroll();  // hard reset of the variable to make sure data is cleared
    System.out.println("\n\nEnter employee "+counter+" details\n");
    payroll.SetPayrollDetail();
    payroll.SetBonus();
    payroll.SetCommission();
    payroll.SetNssf();
    payroll.SetNetSalary();

    PayrollList[counter] = payroll; // adds it to the array at position counter
}

for(counter=0; counter<=limit - 1; counter++){
    PayrollList[counter].GetPayroll(); // gets the payroll2 object from the array and calls its function
}