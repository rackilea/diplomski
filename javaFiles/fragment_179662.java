public Money add(Money addition) {
    checkCurrency(addition);

    amount = amount.add(addition.getAmount());
    return new Money(amount, currency);
}