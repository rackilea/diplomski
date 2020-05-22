@Bean
InitializingBean createTestEntries(@Autwired JdbcTemplate jdbc) {
return () -> {

    testObject t1 = new testObject (values...);
    testRepo.save(t1);

    jdbc.update("custom SQL here")
}