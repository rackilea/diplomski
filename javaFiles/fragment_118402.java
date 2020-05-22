public Optional<JSONObject> save(byte[] multipartFile, String fileName) {
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        Resource content = new MultipartByteArrayResource(multipartFile , fileName);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Resource> requestEntityBody = new HttpEntity<Resource>(content, headers);
        body.add("aaa", requestEntityBody);
        String result = "";
        JSONParser parser = new JSONParser();
        JSONObject json = null;


        HttpHeaders requestHeaders = new HttpHeaders();
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, requestHeaders);
        ResponseEntity<String> response = null;
        try {
           RestTemplate restTemplate = customizeRestTemplate(); //I have defined this in different config file in my actual code
           response =  restTemplate.exchange(url , HttpMethod.POST , requestEntity , String.class);
           result = (response != null && response.getBody() != null) ? response.getBody().toString() : result;
           json = (JSONObject) parser.parse(result);
           LOG.info( "Response:", response );

        } catch (Exception exception) {
            LOG.error("Error , exception);
            return Optional.empty();
        }
        return Optional.ofNullable(json);
    }

   public class MultipartByteArrayResource extends ByteArrayResource{

       private String fileName;

        public MultipartByteArrayResource(byte[] byteArray , String filename) {
               super(byteArray);
               this.fileName = filename;
           }

        public String getFilename() { 
            return fileName; 
          }

        public void setFilename(String fileName) {
            this.fileName= fileName;
         }

     }

      public RestTemplate customizeRestTemplate() {

            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            requestFactory.setReadTimeout(10000);
            requestFactory.setConnectTimeout(10000);

            RestTemplate restTemplate = new RestTemplate(requestFactory);
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
            messageConverters.add(new FormHttpMessageConverter());
            messageConverters.add(new StringHttpMessageConverter());
            restTemplate.setMessageConverters(messageConverters);
            return restTemplate;
        }

}