List<Emp> employe = Arrays.asList(new Emp(1, 100), new Emp(2, 200), new Emp(3, 300));
  List<Emp> employeRise = employe.stream()
                                 .map(emp -> new Emp(emp.getId(), emp.getSalary * 100))
                                 .collect(Collectors.toList());
  employeRise.stream()
            .forEach(s -> System.out.println("Id :" + s.getId() + " Salary :" + s.getSalary()));