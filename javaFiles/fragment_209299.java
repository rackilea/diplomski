// Check if it is @FormParam or @QueryParam
for (Annotation annotation : annots) {
    if (!ANNOTATIONS.contains(annotation.annotationType())) {
        return null;
    }
}