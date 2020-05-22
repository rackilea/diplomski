private ObjectMapper customObjectMapper() {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    module.addSerializer(Date.class, new CustomDateFormatter());
    mapper.registerModule(module);
    mapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
    return mapper;
}

private MappingJackson2JsonView jsonView() {
    MappingJackson2JsonView view = new MappingJackson2JsonView();
    view.setObjectMapper(customObjectMapper());
    return view;
}

@Bean
public ContentNegotiatingViewResolver viewResolver() {
    ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
    List<View> viewList = new ArrayList<>();
    viewList.add(jsonView());
    cnvr.setDefaultViews(viewList);
    return cnvr;
}