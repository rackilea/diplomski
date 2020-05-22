ClassPathScanningCandidateComponentProvider scanner =
new ClassPathScanningCandidateComponentProvider(<DO_YOU_WANT_TO_USE_DEFAULT_FILTER>);

scanner.addIncludeFilter(new AnnotationTypeFilter(<TYPE_YOUR_ANNOTATION_HERE>.class));

for (BeanDefinition bd : scanner.findCandidateComponents(<TYPE_YOUR_BASE_PACKAGE_HERE>))
    System.out.println(bd.getBeanClassName());