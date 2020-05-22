ClassPathScanningCandidateComponentProvider scanner =
    new ClassPathScanningCandidateComponentProvider();

scanner.addIncludeFilter(new AnnotationTypeFilter(Component.class));
scanner.addExcludeFilter(new TypeFilter(){
    public boolean match(MetadataReader metadataReader, 
                         MetadataReaderFactory metadataReaderFactory){
        return metadataReader.getAnnotationMetadata()
                 .getAnnotationAttributes(Component.class.getName())
                 .get("value").matches("WEB.Agent-[0-9]+");
    }
});

for (BeanDefinition bd : scanner.findCandidateComponents("com.project.abc.web.Agent1"))
    System.out.println(bd.getBeanClassName());