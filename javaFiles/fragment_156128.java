@Override
public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
        ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {

         ClientHttpResponse  response=clientHttpRequestExecution.execute(httpRequest, bytes);
         //...do magic with response body from getBody method
         return response;
}