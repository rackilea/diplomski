private static class EmployeeDetailsSummaryCollector implements Collector<EmployeeDetails, Summary, Summary> {
    @Override
    public Supplier<Summary> supplier() {
        return Summary::new;
    }

    @Override
    public BiConsumer<Summary, EmployeeDetails> accumulator() {
        return (summary, employeeDetails) -> {
            summary.salarySum += employeeDetails.salary;
            summary.bonusSum += employeeDetails.bonus;
        };
    }

    @Override
    public BinaryOperator<Summary> combiner() {
        return (summary, summary1) -> {
            summary.salarySum += summary1.salarySum;
            summary.bonusSum += summary1.bonusSum;
            return summary;
        };
    }

    @Override
    public Function<Summary, Summary> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Collector.Characteristics.IDENTITY_FINISH);
    }
}