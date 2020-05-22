static void payOneEmployee(Scanner aScanner) {
    Employee anEmployee = new Employee();

    anEmployee.setName(aScanner.nextLine());
    anEmployee.setJobTitle(aScanner.nextLine());
    anEmployee.cutCheck(aScanner.nextDouble());
    if (aScanner.hasNextLine()) {
        aScanner.nextLine();
    }
}