@Override
public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

    ExposureConfiguration exposureConfiguration = config.getExposureConfiguration();

    exposureConfiguration.forDomainType(User.class)
        .withAssociationExposure((metdata, httpMethods) -> httpMethods.disable(HttpMethod.GET));
}