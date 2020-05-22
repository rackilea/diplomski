@Bean
@Qualifier("service")
public HttpInvokerProxyFactoryBean invoker() {
    HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
    invoker.setServiceUrl(testUrl);
    invoker.setServiceInterface(Service.class);
    // set our custom request executor
    CustomHttpInvokerRequestExecutor executor = new CustomHttpInvokerRequestExecutor();
    invoker.setHttpInvokerRequestExecutor(executor);

    return invoker;
}

@Autowired
CustomRemoteExecutor executor;

@Autowired
Service service;

public void invoke(Bean bean) {

    // when you need custom headers
    Map<String, String> headers = new HashMap<>();
    headers.put("CUSTOM_HEADER", "CUSTOM_VALUE");
    headers.put("CUSTOM_HEADER2", "CUSTOM_VALUE2");
    executor.executeInTemplate(headers, () -> service.process(bean));

}