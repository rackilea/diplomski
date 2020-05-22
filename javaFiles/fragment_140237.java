public static class IgnoreIntrospector extends JacksonAnnotationIntrospector {

    @Override
    public boolean hasIgnoreMarker(AnnotatedMember m) {
      return m instanceof AnnotatedField && _findAnnotation(m, MyInclude.class) == null;
    }
  }