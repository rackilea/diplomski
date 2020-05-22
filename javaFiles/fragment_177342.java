private @Autowired BeanFactory beanFactory;

public Client getClient(int id) {
    List<Client> clients= getSimpleJdbcTemplate().query(
            CLIENT_GET,
            new RowMapper<Client>() {
                public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Client client = beanFactory.getBean(Client.class);
                    client.setId(rs.getInt(1));
                    client.setName(rs.getString(2));
                    return client;
                }
            },id
    );
    return clients.get(0);
}