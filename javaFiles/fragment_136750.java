URI uri= UriBuilder
    .fromPath("your_domain")
    .scheme("http")
    .path("your_path/")
    .queryParam("param1", "value1")
    .build();

URI uri = builder.build();