@Then("^following list of employees are returned$")
public void following_list_of_employees_are_returned(DataTable expectedEmployees) {
    List<Employee> employees = response.as(Employee[].class);

    DataTable actualEmployees = createTable(
            employees,
            asList("id", "name", "department"),
            Employee::getId, Employee::getName, Employee::getDepartment
    );
    assertThat(actualEmployees, hasTheSameRowsAs(expectedEmployees));
}


static <T> DataTable createTable(List<T> values, List<String> headers, Function<T, Object>... extractors) {
    List<List<String>> rawTable = new ArrayList<>();
    rawTable.add(headers);
    values.stream()
            .map(employee -> Stream.of(extractors)
                    .map(f -> f.apply(employee))
                    .map(String::valueOf)
                    .collect(Collectors.toList()))
            .forEach(rawTable::add);
    return create(rawTable);
}