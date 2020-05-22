String result = Stream.<Collector<Employee,?,?>>of(
            Collectors.summingInt(Employee::getSalary),
            Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
            Collectors.minBy(Comparator.comparing(Employee::getSalary)),
            Collectors.averagingLong((Employee e) ->e.getSalary() * 2),
            Collectors.counting())
        .map(collector -> employees.stream().collect(collector))
        .map(Object::toString)
        .collect(Collectors.joining(", "));