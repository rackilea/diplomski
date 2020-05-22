boolean hasParamAnnotation = false;
for (Annotation annotation : annots) {
    if (ANNOTATIONS.contains(annotation.annotationType())) {
        hasParamAnnotation = true;
        break;
    }
}

if (!hasParamAnnotation) return null;