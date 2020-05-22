Optional<User> getRichestEmployee() {
    return getUserStream()
            .max(Comparator.comparing(this::getEmployeeAmountInPLN));
}

BigDecimal getEmployeeAmountInPLN(final User user) {
    return user.getAccounts()
            .stream()
            .map(this::getAccountAmountInPLN)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
}

BigDecimal getAccountAmountInPLN(final Account account) {
    return account
            .getAmount()
            .multiply(BigDecimal.valueOf(account.getCurrency().rate))
            .round(new MathContext(4, RoundingMode.HALF_UP));
}