List< HttpMessageConverter<?> > messageConverters = new ArrayList< HttpMessageConverter<?> >();   
// empty list created

messageConverters.add( new MappingJacksonHttpMessageConverter() );   
// list has 1 elem now

restTemplate.getMessageConverters().add(new StringHttpMessageConverter());  
// adds StringHttpMessageConverter to restTemplate converter list

restTemplate.setMessageConverters( messageConverters );
// replaces restTemplate converter list with your custom list containing MappingJacksonHttpMessageConverter only
// original list containing StringHttpMessageConverter is LOST