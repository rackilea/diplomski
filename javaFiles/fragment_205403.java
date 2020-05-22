public Set<String> areas(final List<Employee> employees) {
    return Sets.newHashSet(
        Lists.transform(employees, new Function<Employee, String>() {
            public String apply(Employee e) {
                return e.getArea();
            }
        }));
}