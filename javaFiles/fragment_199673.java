public void SetPayrollDetail()
{
    System.out.println("Enter ID: ");
    empID = myScanner.nextInt();

    System.out.println("Enter Name: ");
    empName = myScanner.next();

    System.out.println("Enter Department (Marketing or Other): ");
    empDept = myScanner.next();

    System.out.println("Enter Designation (Manager, Executive or Other):");
    designation = myScanner.next();

    System.out.println("Enter Basic Salary: ");
    basicSalary = myScanner.nextInt();

}