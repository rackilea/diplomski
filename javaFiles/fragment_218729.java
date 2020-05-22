public AccountConcurrencyUtils {

    public static synchronized Account addAccount(Account acct, SessionType session) {
        session = sessionFactory.getCurrentSession();
        session.save(acct);
        session.flush();
        session.clear();
        return acct;
    }

}