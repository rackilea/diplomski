LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
map.add("file", new ClassPathResource(file));
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.MULTIPART_FORM_DATA);

HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new    HttpEntity<LinkedMultiValueMap<String, Object>>(
                    map, headers);
ResponseEntity<String> result = template.get().exchange(
                    contextPath.get() + path, HttpMethod.POST, requestEntity,
                    String.class);