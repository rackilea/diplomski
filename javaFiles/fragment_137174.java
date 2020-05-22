@Override
public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(NameToken.class)) {
        System.out.println(annotatedElement.getEnclosingElement()); // prints "Start"
    }
    return true;
}