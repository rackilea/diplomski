public Map<String, Double> getValueForActivity() {
    return this.allActiv.values()
            .stream()
            .collect(Collectors.toMap(Activity::getName, this::sumExpenses));
}

private double sumExpenses(Activity activity) {
    return this.expenses.values()
            .stream()
            .filter(e -> this.userId.equals(e.getCustomerId()))
            .filter(e -> e.getActivity().equals(activity))
            .mapToDouble(Expense::getExpenseValue)
            .sum();
}