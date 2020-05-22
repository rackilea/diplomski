@Override
public boolean process(final Set<? extends TypeElement> annotations, 
        final RoundEnvironment roundEnv) {
    checkEnvironmentChange();
    System.out.println("   > ---- process2 method starts " + hashCode());
    System.out.println("   > annotations: " + annotations);

    for (final TypeElement annotation: annotations) {
        System.out.println("   >  annotation: " + annotation.toString());
        processAnnotation(roundEnv, annotation);
    }
    System.out.println("   > processingOver: " + roundEnv.processingOver());
    System.out.println("   > ---- process2 method ends " + hashCode());
    return false;
}

private void processAnnotation(final RoundEnvironment roundEnv, 
        final TypeElement annotation) {
    final Set<? extends Element> annotateds = 
            roundEnv.getElementsAnnotatedWith(annotation);
    for (final Element element: annotateds) {
        processElement(element);
    }
}

private void processElement(final Element element) {
    System.out.println("      > class: " + element);
    System.out.println("      > class2: " + element.getClass());
    final List<? extends Element> enclosedElements = 
            element.getEnclosedElements();
    for (final Element enclosedElement: enclosedElements) {
        processEnclosedElement(enclosedElement);
    }
}

private void processEnclosedElement(final Element enclosedElement) {
    final XmlElements xmlElements = 
            enclosedElement.getAnnotation(XmlElements.class);
    if (xmlElements == null) {
        return;
    }
    final XmlElement[] xmlElemntValues = xmlElements.value();
    for (final XmlElement xmlElementValue: xmlElemntValues) {
        System.out.println("           > name: " + xmlElementValue.name());
    }
}