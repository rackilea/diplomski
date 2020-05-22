public class RestConfig
{
    /**
     * Bean to make jackson automatically convert from
     * camelCase (java) to under_scores (json) in property names
     *
     * @return ObjectMapper that maps from Java camelCase to json under_score names
     */
    @Bean
    public ObjectMapper jacksonObjectMapper()
    {
        return new ObjectMapper().setPropertyNamingStrategy(propertyNamingStrategy());
    }

    @Bean
    public PropertyNamingStrategy propertyNamingStrategy()
    {
        return new UpperCaseUnderscoreStrategy();
    }

    @Bean
    public RestTemplate restTemplate() {
       RestTemplate restTemplate = new RestTemplate();
       List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
       MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
       jsonMessageConverter.setObjectMapper(jacksonObjectMapper());
       messageConverters.add(jsonMessageConverter);
       restTemplate.setMessageConverters(messageConverters); 

       return restTemplate;
    }
}