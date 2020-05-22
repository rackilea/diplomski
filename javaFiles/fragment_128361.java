for (Element element : roundEnv.getElementsAnnotatedWithAny​(Set.of(PathParam.class,
                                                                   QueryParam.class))) {
    PathParam pathParam = element.getAnnotation(PathParam.class);
    if (pathParam != null) {
        String value = pathParam.value();
        // Process @PathParam value
    }
    QueryParam queryParam = element.getAnnotation(QueryParam.class);
    if (queryParam != null) {
        String value = queryParam.value();
        // Process @QueryParam value
    }
}