class MetaProperty<A, R> {
    MetaProperty(Function<A, R> getter) { /* */ }
}

 public static final MetaProperty<Account, Integer> BALANCE_PROP_INVALID 
                                                    = new MetaProperty<>(Account::getBalance);