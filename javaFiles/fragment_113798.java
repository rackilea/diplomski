@Repository("accountDAO")
public class AccountDAO implements AbstractDAO<Account> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void add(Account object) {
        ...
    }
    ...
}