Iterator<Employee> empIt = list.listIterator();    

    while (empIt.hasNext()) {
        Employee current = empIt.next();
        if (current.getEmployeeID() == selectedEmployeesID) {
            empIt.remove();
        }

    }