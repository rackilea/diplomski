List<EmployeeFX> employeeList = new ArrayList<>();
try {
    File file = new File("C:\\Users\\Jason\\workspace\\EmpData");
    Scanner scan = new Scanner(file);
    scan.nextLine(); // to skip first line in file
    while (scan.hasNextLine()) { // while file has another line
        int id = scan.nextInt(); // read the next integer
        String fName = scan.next(); // read the next string
        String lName = scan.next(); // read the next string
        Boolean sd = scan.nextBoolean(); // read the next boolean
        Long s = scan.nextLong(); // read the next long

        // add variables to the object
        employeeList.add(new EmployeeFX(id, fName, lName, sd, s));
    }

    outputData("Output in ORIGINAL order.", employeeList,
            EmployeeOrdering.ORIGINAL);
    outputData("Output in SALARIED order.", employeeList,
            EmployeeOrdering.SALARIED);
    outputData("Output in NAME order.", employeeList, EmployeeOrdering.NAME);
    outputData("Output in EMPLOYEE_ID order.", employeeList,
            EmployeeOrdering.EMPLOYEE_ID);
    outputData("Output in SALARY order.", employeeList,
            EmployeeOrdering.SALARY);
} catch (Exception e) {
    System.out.println(e.getMessage());
}