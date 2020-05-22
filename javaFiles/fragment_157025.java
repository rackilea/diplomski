for (Element element : roundEnv.getElementsAnnotatedWith(AnnotationOnMethod.class)) {
    TypeElement typeElement = elementUtils.getTypeElement(element.asType().toString());
    Set<? extends Element> fields = typeElement.getEnclosedElements()
            .stream()
            .filter(o -> o.getKind().isField())
            .collect(Collectors.toSet());

    // do something with the fields
}