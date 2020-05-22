import java.util.List;

public class AccountService {

    private AccountRepository accountRepository;

    public List<Account> getAccounts(List<Long> ids) {
        return PartitionArray.partitionAndDoBusinessFunction(ids, accountRepository::getAccounts, 30000);
    }
}