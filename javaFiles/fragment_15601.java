public class TicketDao {

    public static final String DELETE_QUERY = "delete from Ticket where id = ?";
    public static final String INSERT_QUERY = "insert into Ticket values(?, ?)";
    public static final String GET_ALL_QUERY = "select * from Tickets";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Set<Ticket> getAll() {
        return new HashSet<>(jdbcTemplate.query(GET_ALL_QUERY, new RowMapper<Ticket>() {
            @Override
            public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getString(1));
                //other fields mapping
                return ticket;
            }
        }));
    }

    public void remove(Ticket ticket){
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(DELETE_QUERY);
                statement.setString(1, ticket.getId());

                return statement;
            }
        });
    }

    public void put(Ticket ticket){
        Object[] values = {ticket.getId(), ticket.getName()};
        int[] types = {Types.VARCHAR, Types.VARCHAR};

        jdbcTemplate.update(INSERT_QUERY, values, types);
    }
}