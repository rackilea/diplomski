public class TransactionSummary {

    private final BigDecimal amount;
    private final Map<String, BigDecimal> acctToTotal;

    TransactionSummary(Map<String, BigDecimal> acctToTotal) {
        this.acctToTotal = Collections.unmodifiableMap(acctToTotal);
        this.amount = acctToTotal.values().stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Collector<Transaction, ?, TransactionSummary> collector() {
        // this can be a static constant
        return collectingAndThen(
            toMap(Transaction::getAccountNumber,Transaction::getAmount,BigDecimal::add),
            TransactionSummary::new
        );
    }

    // getters
}