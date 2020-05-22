@Component
public class SomeBean {

    @Value("${jdbc.url}") 
    private String jdbcUrl;
}