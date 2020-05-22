AnnotationIntrospector annotationInspector = new JacksonAnnotationIntrospector();
AnnotatedClass annotatedClass = AnnotatedClass.constructWithoutSuperTypes(OID.class,
                new ObjectMapper().getSerializationConfig());
List<NamedType> subtypes = annotationInspector.findSubtypes(annotatedClass);

for(NamedType type: subtypes){
    if(type.getType().getName().contains(typeId)){
        return type.getClass().newInstance();   
    }

}