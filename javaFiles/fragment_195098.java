public static void contributeRegistryStartup(
     final Logger logger, final LiquibaseService liquibaseService,
     OrderedConfiguration<Runnable> configuration)
    {
        configuration.add("Liquibase", new Runnable()
        {
            public void run()
            {
                logger.info("Updating database by liquibase service...");
                liquibaseService.update();
                logger.info("update-db done.");
            }
        }, "after:HibernateStartup");
    }