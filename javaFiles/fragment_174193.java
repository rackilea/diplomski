// ...
    List<Employee> employees = employeeQuery.getResultList();

    // NEW:  Update owning side     
    for (Employee e : employees) {
        e.setDepartment(dept);
    }
    currentEmpinDept.addAll(employees);
    dept.setEmployees(currentEmpinDept);

    //em.merge(dept);   - DON'T THINK THIS IS NEEDED
}