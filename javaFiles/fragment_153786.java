@Bean
public ResourceOwnerPasswordResourceDetails resource() {
       ResourceOwnerPasswordResourceDetails  r = new ResourceOwnerPasswordResourceDetails ();
       r.setUsername("asdfasdf");
    ....

}
@Bean
public OAuth2RestTemplate restTemplate() {
      OAuth2RestTemplate rest = new OAuth2RestTemplate(resource());
      rest.setMessageConverters(...);
      List<HttpMessageConverter<?>> messageConv = new ArrayList<HttpMessageConverter<?>>();
      messageConv.add(new MappingJackson2HttpMessageConverter());
      rest.setMessageConverters(messageConv);
}