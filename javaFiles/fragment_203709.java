@Component
public class CustomRemoteExecutor {

@Autowired
private HttpInvokerProxyFactoryBean factoryBean;

/*
 * May be you should need a synchronized modifier here if there is possibility
 * of multiple threads access here at the same time
 */
public void executeInTemplate(Map<String, String> headers, Runnable task) {
    CustomHttpInvokerRequestExecutor executor = (CustomHttpInvokerRequestExecutor) factoryBean.getHttpInvokerRequestExecutor();
    executor.setHeaders(headers);
    task.run();
}