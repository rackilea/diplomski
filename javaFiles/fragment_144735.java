ResponseEntity<byte[]> response = restTemplate.getForEntity(apiUrl, byte[].class);
GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(response.getBody()));

// convert the stream to string
StringWriter writer = new StringWriter();
IOUtils.copy(gzip, writer, "UTF-8");
String responseString = writer.toString();