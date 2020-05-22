private ResourceDatabasePopulator databasePopulator() {
    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScripts(new ClassPathResource("/sql/products/Create.sql"),
            new ClassPathResource("/sql/products/Load.sql"),
            new ClassPathResource("/sql/products/Insert.sql"),
            new ClassPathResource("/sql/products/Update.sql"),
            new ClassPathResource("/sql/products/Drop.sql"));

    return populator;
}

// The scheduled method
@Scheduled(fixedDelay = 15000) // Every 15 sec
public void updateProductsTable() {
    databasePopulator().execute(dataSource());
}