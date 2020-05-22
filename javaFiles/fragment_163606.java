public class CustomMappingJackson2HttpMessageConverter
        extends org.springframework.http.converter.json.MappingJackson2HttpMessageConverter {

    public CustomMappingJackson2HttpMessageConverter() {
        super();
    }

    public CustomMappingJackson2HttpMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    @Override
    public void setJsonPrefix(String jsonPrefix) {
        super.setJsonPrefix(jsonPrefix+"\n");
    }   

}