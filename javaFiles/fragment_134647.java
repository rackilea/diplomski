final List<EmployeeDetails> employees = asList(
        new EmployeeDetails(/* deptName */"A", /* salary */ 100d, /* bonus */ 20d),
        new EmployeeDetails("A", 150d, 10d),
        new EmployeeDetails("B", 80d, 5d),
        new EmployeeDetails("C", 100d, 20d)
);

final Collector<EmployeeDetails, Summary, Summary> collector = new EmployeeDetailsSummaryCollector();
final Map<String, Summary> map = employees.stream()
        .collect(Collectors.groupingBy(o -> o.deptName, collector));
System.out.println("map = " + map);