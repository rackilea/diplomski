import java.util.List;

public class AccountService {

    private AccountRepository accountRepository;

    public List<Account> getAccounts(List<Long> ids) {
        return PartitionArray.partitionAndDoBusinessFunction(ids, idList -> {
            List<Account> accounts = accountRepository.getAccounts(idList);
            // do more business on accounts
            return accounts;
        }, 30000);
    }
}