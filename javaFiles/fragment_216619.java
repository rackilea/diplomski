/**
   * For Class attribute, if we invoke directly, it may throw {@link MirroredTypeException} because the class has not be
   * compiled. Use this method to get the Class value safely.
   *
   * @param elements Elements for convert Class to TypeMirror
   * @param anno annotation object
   * @param func the invocation of get Class value
   * @return the value's {@link TypeMirror}
   */
  public static <T extends Annotation> TypeMirror getAnnotationClassValue(Elements elements, T anno,
      Function<T, Class<?>> func) {
    try {
      return elements.getTypeElement(func.apply(anno).getCanonicalName()).asType();
    } catch (MirroredTypeException e) {
      return e.getTypeMirror();
    }
  }