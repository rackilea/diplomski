@Configuration
class FlywayConfig {
    @Bean
    fun flyway(dataSource: DataSource): Flyway {
        val flyway = Flyway()
        flyway.dataSource = dataSource
        return flyway
    }

    @Bean
    fun flywayInitializer(flyway: Flyway): FlywayMigrationInitializer {
        return FlywayMigrationInitializer(flyway, null)
    }

    /**
     * Additional configuration to ensure that [EntityManagerFactory] beans depend on the
     * `flywayInitializer` bean.
     */
    @Configuration
    class FlywayInitializerJpaDependencyConfiguration : EntityManagerFactoryDependsOnPostProcessor("flywayInitializer")
}