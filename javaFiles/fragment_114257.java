public class ResponseHeaderClientRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        HttpHeaders responseHeader = response.getHeaders();
        RequestAttributes requestAttrs = RequestContextHolder.getRequestAttributes();
        if (requestAttrs != null) {
            requestAttrs.setAttribute("responseHeader", responseHeader, RequestAttributes.SCOPE_REQUEST);
        }
        return response;
    }
}