@Service
public MyService {
    @Autowired
    JdbcTemplate template;
    @Autowired
    Something something;

    public void doSomething() {
        template.query("select * from something", new RowCallbackHandler() {
            public void processRow(ResultSet rs) {
                System.out.println(something);
                //actually do something
            }
        });
    }
}