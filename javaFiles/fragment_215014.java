@Configuration
public class MyConfiguration {

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    @Autowired
    private MyHttpMessageConverter myHttpMessageConverter;

    @PostConstruct
    private void modify() {
        List<HttpMessageConverter<?>> messageConverters = adapter.getMessageConverters();
        int insertLocation = messageConverters.size() - 1;
        for (int i = 0; i < messageConverters.size(); i++) {
            Object messageConverter = messageConverters.get(i);
            if (messageConverter instanceof MappingJackson2HttpMessageConverter) {
                insertLocation = i;
            }
        }
        messageConverters.add(insertLocation, myHttpMessageConverter);
    }
}