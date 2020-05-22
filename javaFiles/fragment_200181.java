RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
headers.setAccept(Arrays.asList(MediaType.APPLICATION_PDF, MediaType.APPLICATION_OCTET_STREAM));
HttpEntity<String> entity = new HttpEntity<>(headers);

ResponseEntity<byte[]> result =
restTemplate.exchange(uri, HttpMethod.GET, entity, byte[].class);


byte[] content = response.getBody();
Files.write(Paths.get("/home/123.pdf"), content, StandardOpenOption.CREATE );