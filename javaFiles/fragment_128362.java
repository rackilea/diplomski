for (Element element : roundEnv.getElementsAnnotatedWithAny​(Set.of(PathParam.class,
                                                                   QueryParam.class))) {
    String value = null;
    PathParam pathParam = null;
    QueryParam queryParam = null;
    if ((pathParam = element.getAnnotation(PathParam.class)) != null) {
        value = pathParam.value();
    } else if ((queryParam = element.getAnnotation(QueryParam.class)) != null) {
        value = queryParam.value();
    }
    // Process value. Exactly one of pathParam and queryParam will be non-null
}