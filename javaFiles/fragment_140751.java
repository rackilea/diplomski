public class SessionFactoryFactory 
        extends AbstractContainerRequestValueFactory<SessionFactory> {

    @Inject
    @Named("EnglishSessionFactory")
    private SessionFactory englishSessionFactory;

    @Inject
    @Named("FrenchSessionFactory")
    private SessionFactory frenchSessionFactory;

    @Override
    public SessionFactory provide() {
        ContainerRequest request = getContainerRequest();
        String lang = request.getUriInfo().getQueryParameters().getFirst("lang");
        if (lang != null && "fr".equals(lang)) {
            return frenchSessionFactory;
        } 
        return englishSessionFactory;
    }
}