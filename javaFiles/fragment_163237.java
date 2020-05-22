private void performFlywayMigration(DataSource dataSource) {
    Flyway flyway = new Flyway();
    flyway.setLocations("db/migration");
    flyway.setDataSource(dataSource);
    log.debug("Starting database migration.");
    flyway.migrate();
    log.debug("Database migration completed.");

    MigrationInfo current = flyway.info().current();
    if (current.getState() == MigrationState.FUTURE_SUCCESS) {
        log.warn("The Database schema is version " + current.getVersion() + ", this application expects version " + flyway.getBaselineVersion().getVersion());
    }
}