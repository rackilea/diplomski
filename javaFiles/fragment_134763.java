String cookieHeader = null;

new ResponseExtractor<T>(){
      T extractData(ClientHttpResponse response) {
        response.getHeaders();
      }
}