public Set<String> areas(final List<Employee> employees) {
    Set<String> areas = new HashSet<>();
    for(final Employee employee: employees) {
        areas.add(employee.getArea());
    }
    return areas;
}