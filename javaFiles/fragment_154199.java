@Bean
  public Jackson2ObjectMapperBuilderCustomizer configureJackson() {

    return jackson2ObjectMapperBuilder -> {

      TypeResolverBuilder<?> typeResolver = new ObjectMapper.DefaultTypeResolverBuilder(OBJECT_AND_NON_CONCRETE);
      typeResolver = typeResolver.init(JsonTypeInfo.Id.CLASS, null);
      typeResolver = typeResolver.inclusion(JsonTypeInfo.As.WRAPPER_ARRAY);

      jackson2ObjectMapperBuilder.defaultTyping(typeResolver);
    };
  }