public static double calculateAveragePay(Employee[] employees, Predicate<Employee> pred) {
    return Arrays.stream(employees)
                 .filter(pred)
                 .mapToDouble(e -> e.calculatePay()) 
                 .average().orElse(0);
}