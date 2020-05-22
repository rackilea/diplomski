String stats = employees.stream().collect(joining(", ",
        Collectors.summingInt(Employee::getSalary),
        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
        Collectors.minBy(Comparator.comparing(Employee::getSalary)),
        Collectors.averagingLong((Employee e) ->e.getSalary() * 2),
        Collectors.counting()));