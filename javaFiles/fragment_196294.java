public class MetadataProvider implements SessionFactoryBuilderFactory {

    private static MetadataImplementor metadata;

    @Override
    public SessionFactoryBuilder getSessionFactoryBuilder(MetadataImplementor metadata, SessionFactoryBuilderImplementor defaultBuilder) {
        this.metadata = metadata;
        return defaultBuilder; //Just return the one provided in the argument itself. All we care about is the metadata :)
    }

    public static MetadataImplementor getMetadata() {
        return metadata;
    }
}