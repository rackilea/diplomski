@AttributeOverrides(value = {
    @AttributeOverride(name = "date", column = @Column(name = "openingBalanceDate") ),
    @AttributeOverride(name = "amount", column = @Column(name = "openingBalanceAmount") ),
    @AttributeOverride(name = "amount", column = @Column(name = "openingBalanceCurrency") )})
@Embedded
@Basic(optional = true)
private AccountBalance openingBalance;