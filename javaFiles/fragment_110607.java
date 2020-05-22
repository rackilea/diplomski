public class CustomFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
        throws IOException {
        Set<String> annotations = metadataReader.getAnnotationMetadata().getAnnotationTypes();

        return annotations.contains(Configuration.class.getName())
            && !annotations.contains(ConditionalOnWebApplication.class.getName());
    }

}