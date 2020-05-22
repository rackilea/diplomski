public interface AnnotationReader<T,C,F,M> {

// ...

    /**
     * Reads an annotation on a property that consists of a field.
     */
    <A extends Annotation> A getFieldAnnotation(Class<A> annotation,
                                                F field, Locatable srcpos);

    /**
     * Checks if the given field has an annotation.
     */
    boolean hasFieldAnnotation(Class<? extends Annotation> annotationType, F field);

// ...

    /**
     * Gets all the annotations on a field.
     */
    Annotation[] getAllFieldAnnotations(F field, Locatable srcPos);

// ...

}