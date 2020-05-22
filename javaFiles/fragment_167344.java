public class AccountRepositoryImpl implements AccountRepositoryCustom {

    @Autowired
    @Lazy
    AccountRepository accountRepository;  /* Optional - if you need it */

    public void customMethod() { ... }
}