public class MyAdvice implements MethodInterceptor {

    @Autowired
    private MessageChannel toJms;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            return invocation.proceed();
        }
        catch Exception(e) {
            Message<?> message = (Message<?>) invocation.getArguments()[0];
            Integer redeliveries = messasge.getHeader("JMXRedeliveryCount", Integer.class);
            if (redeliveries != null && redeliveries > 3) {
                this.toJms.send(message); // maybe rebuild with additional headers about the error
            }
            else {
                throw e;
            }
        }
    }
}