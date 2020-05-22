final TypeFilter entityFilter = new AnnotationTypeFilter(Entity.class);
final TypeFilter customFilter = new AnnotationTypeFilter(CustomAnnotation.class);
TypeFilter andFilter = new TypeFilter {
    boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        return entityFilter.match(metadataReader, metadataReaderFactory) && customFilter.match(metadataReader, metadataReaderFactory);
    }
};
provider.addIncludeFilter(andFilter);