PathMatchingResourcePatternResolver match = new PathMatchingResourcePatternResolver();
MetadataReaderFactory f = new SimpleMetadataReaderFactory();
List<Class<?>> matches = ...;
for (Resource r : match.getResources("classpath*:com/example/**/*.class")) {
    AnnotationMetadata meta = f.getMetadataReader(r).getAnnotationMetadata();
    if (meta.getAnnotationsTypes().contains(MyAnnotation.class.getName()) {
        matches.add(Class.forName(meta.getClassName()));
    }
}
return matches;