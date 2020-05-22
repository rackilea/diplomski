public class AccountDAO extends BaseDAO<Account> {
    public AccountDAO() {
        super(Account.class);
    }

    public List<Account> findByAccountStatus(String status) { ... }
}