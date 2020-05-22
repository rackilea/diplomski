AnnotationValue annValue = entry.getValue();
if (annValue instanceof TypeMirror) {
  return (TypeMirror) annValue;
}
else {
  String valString = annValue.getValue().toString();
  TypeElement elem = processingEnv.getElementUtils().getTypeElement(valString);
  return elem.asType();
}