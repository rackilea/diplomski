public class Money{
    private Currency currency;
    private BigDecimal amount;

    public Money(Currency currency, BigDecimal amount){
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrencyType(){
        return currency;
    }
    public BigDecimal getAmount(){
        return amount;
    }
}