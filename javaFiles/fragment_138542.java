System.out.println("Department total activeCount inactiveCount");
listEmployee.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((dept, emps) -> {
     int count = emps.size();
     long activeCount = emps.stream().filter(e -> "active".equals(e.getActive())).count();
     long inactiveCount = emps.stream().filter(e -> "inactive".equals(e.getActive())).count();
     int i = 12 - dept.length();
     System.out.format(dept + "%" + i +"s" + count + "%10s" + activeCount + "%10s" + inactiveCount, " ", " ", " ");
     System.out.println();
 });