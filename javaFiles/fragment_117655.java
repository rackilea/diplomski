System.out.print( "%n$------------------------------------$");
System.out.printf( "%nWITHHOLDING FOR EACH EMPLOYEE%n%n" );
System.out.printf("%-12s  %-12s  %-12s  %-12s  %-12s \n\n", "First Name", "Last Name", "Hourly Rate", "Weekly Pay", "Withholding Amount");

for( int i = 0; i < employeeNum; i++ ) {
    System.out.printf( "%-12s  %-12s  %-12.3f  %-12.3f  %-12.3f \n", employeeFirstName[i], employeeLastName[i], 
            employeeHourlyPay[i], weeklyPay[i], withholdingAmt[i] );
}
System.out.printf( "%nEND OF REPORT%n" );
System.out.print( "$------------------------------------$");