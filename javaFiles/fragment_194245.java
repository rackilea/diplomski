TypeElement element;
getSuperElement(element.asType());

private void getSuperElement(TypeMirror mirror) {
    if (mirror == null ) return;
    List<? extends TypeMirror> mirrors = mTypeUtils.directSupertypes(mirror);
    if (mirrors == null || mirrors.isEmpty()) return;
    for (TypeMirror it : mirrors) {
        if (it.getKind() == TypeKind.DECLARED) {
            // this element is super class's element, you can do anything in here
            Element element = ((DeclaredType) it).asElement();
        }
        getSuperElement(methodBuilder, componentName, it);
    }
}