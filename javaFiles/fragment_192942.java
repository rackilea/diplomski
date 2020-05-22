@Rest(rootUrl = "http://my.domain.com", converters = {
MappingJacksonHttpMessageConverter.class,
StringHttpMessageConverter.class, GsonHttpMessageConverter.class }, interceptors = {   MyInterceptor.class })
public interface RestClient extends RestClientErrorHandling {

    @Post("/user/register/{name}/{email}/{pass}")
    @Accept(MediaType.APPLICATION_JSON_VALUE)
    User sendUserRegistration(User user, String name, String email,
    String pass);

    RestTemplate getRestTemplate();
}