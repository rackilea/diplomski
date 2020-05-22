@Transactional
public int getUserIdCreateIfNotExistent(String email) throws Exception {
  try {
    jdbcTemplate.queryForRowSet("SELECT pg_advisory_xact_lock(hashtext('users'), hashtext(?))", email);
    return jdbcTemplate.queryForObject("SELECT id FROM users WHERE email = ?", Integer.class, email);
  } catch (IncorrectResultSizeDataAccessException e) {
    Thread.sleep(10000);
    return jdbcTemplate.queryForObject("INSERT INTO users (email) values(?) RETURNING id", Integer.class, email);
  }
}