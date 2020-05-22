@Autowired 
private DataSource dataSource; // Configure this in a class annotated with @Configuration

public Todo fetchWithToDoId(long id) {
    Todo record = new JdbcTemplate(dataSource).queryForObject("SELECT * FROM PUBLIC.TODO WHERE todo_id = ?", new Object[]{id}, getRowMapper());
    return record;
}

private RowMapper<Todo> getRowMapper() {
    return (resultSet, i) -> {
        Todo d = new Todo();
        d.setUserId(resultSet.getInt("todo_user_id"));
        d.setId(resultSet.getInt("todo_id"));
        d.setTitle(resultSet.getString("todo_title"));
        d.setCompleted(resultSet.getBoolean("todo_completed"));
        d.setCreated(resultSet.getTimestamp("todo_created"));
        return d;
    };
}