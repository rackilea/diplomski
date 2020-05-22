@Service
public class ConnectionListener {

    private Connection connection;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
         connection = jdbcTemplate.getDatasource().getConnection();
    }

    @Scheduled(fixedRate = 60000) // check every 60 sec
    public void checkConnection() {
        try {
            connection.isValid(10);
        } catch (SQLException e) { // Or just handle it here
            throw new ConnectionTimeoutException(e);
        }
    }
}