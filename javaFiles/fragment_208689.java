StringBuilder builder = new StringBuilder();
    builder.append("http://localhost:8080/test_tmp");
    builder.append("?max_time=30&users=1000&client_data=");
    builder.append(URLEncoder.encode(xmlData));

    URI uri = URI.create(builder.toString());

    restTemplate.getForObject(uri, String.class);