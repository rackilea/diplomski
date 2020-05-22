public static void main(String[] args) throws Exception {
    ...
    ClassGen aGen = new ClassGen(aClass);
    aGen.setAttributes(cleanupAttributes(aGen.getAttributes()));
    aGen.getFields();
    for (Field field : aGen.getFields()) {
        field.setAttributes(cleanupAttributes(field.getAttributes()));
    }
    for (Method method : aGen.getMethods()) {
        method.setAttributes(cleanupAttributes(method.getAttributes()));
    }
    ...
}

private Attribute[] cleanupAttributes(Attribute[] attributes) {
    for (Attribute attribute : attributes) {
        if (attribute instanceof Annotations) {
            Annotations annotations = (Annotations) attribute;
            if (annotations.isRuntimeVisible()) {
                AnnotationEntry[] entries = annotations.getAnnotationEntries();
                List<AnnotationEntry> newEntries = new ArrayList<AnnotationEntry>();
                for (AnnotationEntry entry : entries) {
                    if (!entry.getAnnotationType().startsWith("javax")) {
                        newEntries.add(entry);
                    }
                }
                annotations.setAnnotationTable(newEntries);
            }
        }
    }
    return attributes;
}