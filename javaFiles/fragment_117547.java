final List<EmployeeEntity> employeeEntities = Arrays
            .asList(new EmployeeEntity(1, "A"), 
                    new EmployeeEntity(2, "B"), 
                    new EmployeeEntity(3, "C"));

final List<Map<String, Object>> listOfEmployeeEntityMap = employeeEntities.stream()
            .map(employeeEntity -> toMap(employeeEntity, "empId", "name"))
            .collect(Collectors.toList());