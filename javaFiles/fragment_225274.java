public CommunicationInstanceBean findOne(int id) {
    String sql = "SELECT * FROM CommunicationInstance WHERE id = ?";
    return getJdbcTemplate().queryForObject(
              sql,
              new BeanPropertyRowMapper<>(CommunicationInstanceBean.class),
              id);
}