public class Money {

    BigDecimal current_Money;

    public Money(BigDecimal money) {
        this.current_Money = money;
    }

    public Money subtract(Money subtractedMoney) {

        // TODO: Validation if needed

        BigDecimal subtractedNumber = current_Money.subtract(subtractedMoney.current_Money);

        if (subtractedNumber.doubleValue() < 0) {
            throw new IllegalArgumentException("Error the Subtracted is in minus...");
        }

        return new Money(subtractedNumber);
    }
}