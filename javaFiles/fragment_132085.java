ObjectMapper mapper = new ObjectMapper();

AnnotationIntrospector primary = new ApiAnnotationIntrospector();
AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();
AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary,
        secondary);

mapper.getDeserializationConfig().setAnnotationIntrospector(pair);
mapper.getSerializationConfig().setAnnotationIntrospector(pair);