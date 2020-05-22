@Bean
public WebResponseExceptionTranslator webResponseExceptionTranslator() {
    return new DefaultWebResponseExceptionTranslator() {
        @Override
        public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
            ResponseEntity<OAuth2Exception> responseEntity = super.translate(e);
            OAuth2Exception body = responseEntity.getBody();
            HttpHeaders headers = new HttpHeaders();
            headers.setAll(responseEntity.getHeaders().toSingleValueMap());

           // translate the exception

            return new ResponseEntity<>(body, headers, responseEntity.getStatusCode());
        }
    };
}