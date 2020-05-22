@Service
class ConnectionLisener {

    private ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
    private Connection connection;

    @PostConstruct
    public void init() {
        connection = jdbcTemplate.getDatasource().getConnection();
        checkConnection();
    }

    @PreDestroy
    public void destroy() {
        service.shutdown();
    }

    public void checkConnection() {
        service.scheduleAtFixedRate(() -> {
            try {
                connection.isValid(10);
            } catch (Exception e) { 
                // handle your exception
            }
        }, 60, 60, TimeUnit.SECONDS);
    }
}