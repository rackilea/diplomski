public static void addEmployeeToList(Employee e) {

    for (int loop = 0; loop < employees.length; loop++) {
        // check there is a space
        if (employees[loop] == null) {
            // add it to free space
            employees[loop] = e;
            break;
        }
    }

}