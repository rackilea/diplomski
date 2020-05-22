private static <K, V extends Collection<? extends Employee>> void print(Map<K, V> map) {
    map.forEach((name, employees) -> {
        int sum = employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println("Employee: " + name + " with salary " + sum);
    });
}