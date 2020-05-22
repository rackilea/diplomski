List<Employee> employees = Stream.of(empIds)
                                 .map(employeeRepository::findById)
                                 .filter(Optional::isPresent)
                                 .map(Optional::get)
                               //.filter(e->e !=null) not needed as it's redundant
                                 .filter(e->e.getSalary()>200000)
                                 .collect(Collectors.toList());