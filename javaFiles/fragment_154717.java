MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
        @Override
        public String getFilename() {
            return file.getName();
        }
};
data.add("file", resource);
HttpHeaders requestHeaders = new HttpHeaders();
requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(data, requestHeaders);

final ResponseEntity<Response<ImportDto>> responseEntity = restTemplate.exchange(url, 
                    HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Response<ResponseDto>>(){});