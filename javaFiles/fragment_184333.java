@RequestMapping(value = "/gettokens", method = RequestMethod.POST, produces = "application/json")
public @ResponseBody ResponseEntity<TokenModel> GetTokens(@RequestBody RequestBodyJson requestBodyJson)
        throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    ResponseEntity<TokenModel> response = null;
    TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
    SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
            .loadTrustMaterial(null, acceptingTrustStrategy).build();
    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
    CloseableHttpClient httpClient = HttpClients.custom()
            .setSSLSocketFactory(csf).build();
    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);
    RestTemplate restTemplate = new RestTemplate(requestFactory);       
    try {                          
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");
        headers.setAll(map);
        HttpEntity<?> _HttpEntityRequestBodyJson = new HttpEntity<>(requestBodyJson, headers); 
        response= restTemplate.exchange(url, HttpMethod.POST,_HttpEntityRequestBodyJson, new ParameterizedTypeReference<TokenModel>() {});  
        System.out.println(response.getBody());
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return response;
}