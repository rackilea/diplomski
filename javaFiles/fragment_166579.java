public class YourAdministration extends AdministrationConfiguration<YourObject> {

    public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder
                .repositoryEventListener(YourRepositoryEventListener.class)
                .build();
    }

}