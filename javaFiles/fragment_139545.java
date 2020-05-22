private static List<MonthlyExpense> createMonthlyExpenses(List<MonthlyExpense> expenses) {
        Map<String, Double> sums = expenses.stream()
                .collect(Collectors.groupingBy(
                            MonthlyExpense::getType, 
                            Collectors.summingDouble(MonthlyExpense::getAmount))
        );
        return sums.entrySet().stream()
                .map(entry -> new MonthlyExpense(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(MonthlyExpense::getType))
                .collect(Collectors.toList());
    }