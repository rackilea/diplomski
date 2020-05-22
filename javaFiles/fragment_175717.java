public void fetchFile() throws IOException {

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(
            new ByteArrayHttpMessageConverter());

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));

    HttpEntity<String> entity = new HttpEntity<String>(headers);

    ResponseEntity<byte[]> response = restTemplate.exchange(
            "https://www.google.com/assets/images/srpr/logo11w.png",
            HttpMethod.GET, entity, byte[].class, "1");

    if (response.getStatusCode() == HttpStatus.OK) {
        // Do something with it..
    }
}