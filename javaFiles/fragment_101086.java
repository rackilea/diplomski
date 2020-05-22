List< HttpMessageConverter<?> > messageConverters = new ArrayList< HttpMessageConverter<?> >();   
// empty list created

messageConverters.add( new MappingJacksonHttpMessageConverter() );      
messageConverters.add( new StringHttpMessageConverter() );  

restTemplate.setMessageConverters( messageConverters );