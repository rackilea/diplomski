@Transactional(value="transactionManager2",propagation = Propagation.REQUIRED)
public class SecondDao {

    @Autowired
    @Qualifier("secondDS")
    private DataSource dataSource;

    public void updateStuff() {
        // updates stuff in the second database using dataSource
    }
}