File file = new File("*********");

HttpHeaders httpHeaders = new HttpHeaders();
httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
form.add("files", file);
form.add("files", file);
form.add("files", file);

form.add("usertoken", "test");
form.add("sendTo", "test");
form.add("subject", "test");
form.add("content", "test");

HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, httpHeaders);

String serverUrl = "****";

restTemplate().postForEntity(serverUrl, requestEntity, String.class);