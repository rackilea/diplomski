val employees: List<Employee> = ...
val partialEmployees: List<PartialEmployee> = employees.map {
    PartialEmployee(
            id = it.id,
            name = it.name
    )
}