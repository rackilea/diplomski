// declare
@Bean("jdbc1")
public JdbcTemplate createJdbcTemplate1(@Autowired @Qualifier("datasource1") DataSource dataSource1){
    return new JdbcTemplate(dataSource1);
}

@Bean("jdbc2")
public JdbcTemplate createJdbcTemplate2(@Autowired @Qualifier("datasource2") DataSource dataSource2){
    return new JdbcTemplate(dataSource2);
}