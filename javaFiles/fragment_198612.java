if (bsalary) {

        salary = new String(ch, start, length);
        System.out.println("Salary : " + salary);
        emp.setSalary(salary);
        testList.add(salary);
        bsalary = false;
        empList.add(emp);
    }