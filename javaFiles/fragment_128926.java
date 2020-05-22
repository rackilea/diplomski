@Override
@Loggable(value = LogLevel.TRACE)
@Transactional
public void updateBalance(String id, BigDecimal amount) {
        Account acc = (Account) sessionFactory.getCurrentSession().get(Account.class, id, LockMode.UPGRADE);
        acc.setBalance(acc.getBalance().subtract(amount));
        save(acc);
}