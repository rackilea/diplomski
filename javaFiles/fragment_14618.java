ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
objectMapper.configure(Feature.ALLOW_COMMENTS, true);
objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, true);
objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
objectMapper.setSerializationInclusion(Include.NON_ABSENT);
objectMapper.registerModule(new JodaModule());
objectMapper.registerModule(new JavaTimeModule());

objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
    @Override
    protected <A extends Annotation> A _findAnnotation(final Annotated annotated,
        final Class<A> annoClass) {
      if (!annotated.hasAnnotation(JsonFormat.class)) {    //since we need to disable JsonFormat annotation.
        return super._findAnnotation(annotated, annoClass);
      }
      return null;
    }
  });


String str = " {\"time\": \"2012-05-01\"}";

ApiClass msg = objectMapper.readValue(str, ApiClass.class);
System.out.println(objectMapper.writeValueAsString(msg ));