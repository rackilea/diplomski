RestTemplate restTemplate = new RestTemplate();
        FormHttpMessageConverter converter = new FormHttpMessageConverter();
        restTemplate.getMessageConverters().add(converter);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultipartByteArrayResource resource = new MultipartByteArrayResource(in);
        resource.setFilename("fileUpload.obj");

        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
        parts.add("name", "fileUpload.obj");
        parts.add("file", resource);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(parts,
                headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange("https://clamav.my.org/scan",
                HttpMethod.POST, requestEntity, String.class);
        String body = (String) responseEntity.getBody();