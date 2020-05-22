Field annotationDataField = Class.class.getDeclaredField("annotationData");
annotationDataField.setAccessible(true);

Object annotationData = annotationDataField.get(pkgInfo);

Field annotationsField = annotationData.getClass().getDeclaredField("annotations");
annotationsField.setAccessible(true);

Map<Class<? extends Annotation>, Annotation> annotations = (Map<Class<? extends Annotation>, Annotation>) annotationsField
        .get(annotationData);
annotations.put(XmlSchema.class, newAnnotation);

XmlSchema modifiedAnnotation = (XmlSchema) pkgInfo.getAnnotations()[0];