@Bean
@Primary
@ConfigurationProperties("spring.datasource")
public DataSource dataSource() {
    return DataSourceBuilder.create().build();
}

@Bean(name = "primaryLiquibaseProperties")
@ConfigurationProperties("liquibase-changelogs.primary.liquibase")
public LiquibaseProperties primaryLiquibaseProperties() {
    return new LiquibaseProperties();
}

@Bean(name = "liquibase")
public SpringLiquibase primaryLiquibase(@Qualifier("primaryLiquibaseProperties") LiquibaseProperties liquibaseProperties) {
    SpringLiquibase primary = new SpringLiquibase();
    primary.setDataSource(dataSource());
    primary.setChangeLog(primaryLiquibaseProperties().getChangeLog());

    return primary;
}

@Bean(name = "metadata_datascource")
@ConfigurationProperties("spring.metadata_datascource")
public DataSource metadataDataSource() {
    return DataSourceBuilder.create().build();
}

@Bean(name = "metadataLiquibaseProperties")
@ConfigurationProperties("liquibase-changelogs.metadate.liquibase")
public LiquibaseProperties metadataLiquibaseProperties() {
    return new LiquibaseProperties();
}

@Bean(name = "metadata-liquibase")
public SpringLiquibase metadataLiquibase(@Qualifier("metadataLiquibaseProperties") LiquibaseProperties liquibaseProperties) {
    SpringLiquibase metadata = new SpringLiquibase();
    metadata.setDataSource(metadataDataSource());
    metadata.setChangeLog(metadataLiquibaseProperties().getChangeLog());

    return metadata;
}