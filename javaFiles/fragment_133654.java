@override
public void createDatabaseSchema() throws DataAccessException
{
    logger.info("Creating database schema for Hibernate SessionFactory");

    SessionFactory sessionFactory = getSessionFactory();
    final Dialect dialect = ((SessionFactoryImplementor) sessionFactory).getDialect();

    final LinkedHashSet<String> sql = new LinkedHashSet<String>();
    for (String query : getConfiguration().generateSchemaCreationScript(dialect))
        sql.add(query);

    HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
    hibernateTemplate.execute(new HibernateCallback<Void>()
    {
        @Override
        public Void doInHibernate(Session session) throws SQLException
        {
            session.doWork(new Work()
            {
                @Override
                public void execute(Connection conn) throws SQLException
                {
                    PhoenixAnnotationSessionFactoryBean.this.executeSchemaScript(conn, sql.toArray(new String[0]));
                }
            });

            return null;
        }
    });

}