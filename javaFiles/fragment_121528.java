@Bean
SessionRepository sessionFactoryBean(JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager) {
    JdbcOperationsSessionRepository sessionRepository = new JdbcOperationsSessionRepository(jdbcTemplate, transactionManager);
    GenericConversionService conversionService = new GenericConversionService();
    conversionService.addConverter(Object.class, byte[].class,
            new SerializingConverter());
    conversionService.addConverter(byte[].class, Object.class,
            new DeserializingConverter(Thread.currentThread().getContextClassLoader()));
    sessionRepository.setConversionService(conversionService);
    return sessionRepository;
}