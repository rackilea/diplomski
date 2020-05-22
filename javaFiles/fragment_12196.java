Map<String, Employee> topEmployees =
    allEmployees.stream()
                .collect(groupingBy(
                    e -> e.department,
                    collectingAndThen(maxBy(comparingInt(e -> e.salary)), Optional::get) 
                ));