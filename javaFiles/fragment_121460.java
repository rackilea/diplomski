public HttpMessageConverters(boolean addDefaultConverters,
        Collection<HttpMessageConverter<?>> converters) {
    List<HttpMessageConverter<?>> combined = getCombinedConverters(converters,
            addDefaultConverters ? getDefaultConverters() : Collections.emptyList());
    combined = postProcessConverters(combined);
    this.converters = Collections.unmodifiableList(combined);
}