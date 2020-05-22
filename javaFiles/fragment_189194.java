Map<String, Map<String, Double>> result = 
     employees.stream()
              .collect(groupingBy(Employee::getCompany,
                              groupingBy(Employee::getDeptId,
                                     reducing(0D, Employee::getSalary,
                                             maxBy(comparingDouble(e -> e))))));