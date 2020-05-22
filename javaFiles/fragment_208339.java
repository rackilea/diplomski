public static void main(String[] args) {
    List<Employee> employeeList = Arrays.asList(new Employee(10), new Employee(15),
            new Employee(21), new Employee(22));

    Map<Boolean, List<Employee>> employeeGroups = employeeList.stream().
                    collect(Collectors.partitioningBy(s -> s.getAge() > 20));

    System.out.println(employeeGroups.get(false));
    System.out.println(employeeGroups.get(true));
}