for (ObjectType type : ObjectType.values()) {
  // Assumes you've created a binding annotation @YourAnnotation(ObjectType) along
  // with an implementation called YourAnnotationImpl.
  bind(Boolean.class)
      .annotatedWith(new YourAnnotationImpl(type))
      .toInstance(Boolean.TRUE));

  // Now you can inject "@YourAnnotation(Type1) Boolean yourValue" and so on.
}