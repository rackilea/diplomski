Map<String, Object> configuration = new HashMap<>();

Integrator integrator = integrator();
if (integrator != null) {
    configuration.put("hibernate.integrator_provider", 
        (IntegratorProvider) () -> Collections.singletonList(
            MetadataExtractorIntegrator.INSTANCE
        )
    );
}

EntityManagerFactory entityManagerFactory = new EntityManagerFactoryBuilderImpl(
    new PersistenceUnitInfoDescriptor(persistenceUnitInfo), 
    configuration
)
.build();