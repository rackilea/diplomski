@Service
...WhateverService class...

@Autowired
private RowMapperClass theRowMapper;


public void doSomething() {
Student student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, theRowMapper);
}