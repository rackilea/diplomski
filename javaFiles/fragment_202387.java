/**
 * @since 1.5
 */
public Annotation[] getAnnotations() {
    return AnnotationParser.toArray(annotationData().annotations);
}

private volatile transient AnnotationData annotationData;

private AnnotationData annotationData() {
    while (true) { // retry loop
        AnnotationData annotationData = this.annotationData;
        int classRedefinedCount = this.classRedefinedCount;
        if (annotationData != null &&
            annotationData.redefinedCount == classRedefinedCount) {
            return annotationData;
        }
        // null or stale annotationData -> optimistically create new instance
        AnnotationData newAnnotationData = createAnnotationData(classRedefinedCount);
        // try to install it
        if (Atomic.casAnnotationData(this, annotationData, newAnnotationData)) {
            // successfully installed new AnnotationData
            return newAnnotationData;
        }
    }
}

private static class AnnotationData {
    final Map<Class<? extends Annotation>, Annotation> annotations;
    final Map<Class<? extends Annotation>, Annotation> declaredAnnotations;

    // Value of classRedefinedCount when we created this AnnotationData instance
    final int redefinedCount;

    AnnotationData(Map<Class<? extends Annotation>, Annotation> annotations,
                   Map<Class<? extends Annotation>, Annotation> declaredAnnotations,
                   int redefinedCount) {
        this.annotations = annotations;
        this.declaredAnnotations = declaredAnnotations;
        this.redefinedCount = redefinedCount;
    }
}