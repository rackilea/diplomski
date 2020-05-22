//code creating list
//...

//our code
Map<String, List<Employee>> grouped = list.stream()
        .filter(e -> e.getSalary() > 55000)
        .filter(e -> e.getSalary() < 120000)
        .sorted(Comparator
                .comparing(Employee::getName)
                .thenComparing(
                        Comparator.comparing(Employee::getSalary).reversed()
                )
        )
        .collect(Collectors.groupingBy(Employee::getName, LinkedHashMap::new, Collectors.toList()));

for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
    System.out.println(entry.getKey());
    for (Employee emp : entry.getValue()) {
        System.out.println("\t" + emp);
    }
}