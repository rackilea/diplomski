Employee arya = new Employee("Stark", "#81, 2nd main, Winterfell", 2, "Arya");
        Employee jon = new Employee("Snow", "#81, 2nd main, Winterfell", 1, "Jon");
        Employee sansa = new Employee("Stark", "#81, 2nd main, Winterfell", 3, "Sansa");

        List<Employee> employees = new ArrayList<>();
        employees.add(jon);
        employees.add(arya);
        employees.add(sansa);

        jsonWriter(employees, "C:/downloads/employees.json");