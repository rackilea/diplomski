public Money add(Money addition) {
    checkCurrency(addition);

    BigDecimal newAmount = amount.add(addition.getAmount());
    return new Money(newAmount, currency);
}