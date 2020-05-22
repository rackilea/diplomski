HttpHeaders headers = new HttpHeaders();
  headers.add("Cookie", cookieHeader );

  ResponseEntity<byte[]> response = restTemplate.exchange("http://example.com/file/123",
      GET,
      new HttpEntity<String>(headers),
      byte[].class);