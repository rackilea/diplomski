publi class MyAnnotationIntrospector extends JacksonAnnotationIntrospector {
    @Override
    protected boolean _isIgnorable(Annotated a) {
        boolean isIgnorable = super._isIgnorable(a);
        if (!isIgnorable) {
            SomeAnnotation ann = a.getAnnotation(SomeAnnotation.class);
            isIgnorable = ann != null;
        }
        return isIgnorable;
    }
}