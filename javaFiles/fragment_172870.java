private String generateKey() {
    final SessionImpl session = ((SessionImpl) em.getDelegate());

    if (generator == null) {
        synchronized (TableGenerator.class) {
            if (generator == null) {
                generator = new TableGenerator();

                ObjectNameNormalizer normalizer = new ObjectNameNormalizer() {

                    @Override
                    protected boolean isUseQuotedIdentifiersGlobally() {
                        return false;
                    }

                    @Override
                    protected NamingStrategy getNamingStrategy() {
                        return new Configuration().getNamingStrategy();
                    }
                };
                Properties params = new Properties();
                params.put("identifier_normalizer", normalizer);
                params.put("table_name", "eflow.docs_num_generators");
                params.put("value_column_name", "GENERATOR_VALUE");
                params.put("segment_column_name", "GENERATOR_KEY");
                params.put("increment_size", "25");
                params.put("segment_value", "2011");
                generator.configure(IntegerType.INSTANCE, params, session
                        .getSessionFactory().getDialect());
            }
        }
    }

    Serializable id = generator.generate(session, new Object());
    return id.toString();
}