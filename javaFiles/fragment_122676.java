Function<TechnicalIssue, String> toName = new Function<>() {
    @Override
    public String apply(TechnicalIssue input) {
        return input.getComputerName();
    }
}
Set<String> computersWithIssues = FluentIterable.from(technicalIssues)
    .transform(toName)
    .toSet();