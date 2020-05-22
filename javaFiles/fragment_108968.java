@Bean
PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
    PersistenceExceptionTranslationPostProcessor p = new PersistenceExceptionTranslationPostProcessor();
    p.setProxyTargetClass(true);
    return p;
}