public String hire(Employee employee) { 
        for (int i = 0; i < arrayList.size(); i++) { // you had employeeNumber instead of arraylist.size() but hire() method does not know anything about that variable
            Employee temp = arraylist.get(i);
            if (temp.getSurname().equals(employee.getSurname)) {
                arrayList.add(employee);
                return "Hired"; // "return" terminates the execution of the method.
            }
        } 
    }