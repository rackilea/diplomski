@Autowired
CustomRemoteExecutor executor;

@Autowired
ISampleService service;

public void invoke(Bean bean) {

    // when you need custom headers
    Map<String, String> headers = new HashMap<>();
    headers.put("CUSTOM_HEADER", "CUSTOM_VALUE");
    headers.put("CUSTOM_HEADER2", "CUSTOM_VALUE2");

    // assume that service.returnSomething() method returns String
    String value = executor.executeInTemplate(headers, () -> service.returnSomething(bean));

}