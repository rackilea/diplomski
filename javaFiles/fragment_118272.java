public class RestTemplate extends org.springframework.web.client.RestTemplate implements InitializingBean {
    @Override
    public void afterPropertiesSet() {
        if(this.getInterceptors() == null){
            this.setInterceptors(new LinkedList<>());
        }
        this.getInterceptors().add(new YourInterceptor());
    }
}

private static class YourInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        //do what you need to do here with the request
        return execution.execute(request, body);
    }
}