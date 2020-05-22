public static List<Annotation> getAllAnnotationsOfPackage(AnnotatedElement
                                   annotatedElement, String annotationsPackage) {
    Annotation[] as = annotatedElement.getAnnotations();
    List<Annotation> asList = new LinkedList<Annotation>();
    for (int i = 0; i < as.length; i++) {
        if (as[i].annotationType().getPackage().getName()
                                               .startsWith(annotationsPackage)) {
            asList.add(as[i]);
        }
    }
    return asList;
}