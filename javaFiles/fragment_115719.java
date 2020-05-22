HttpHeaders headers = new HttpHeaders();
    headers.set("User-agent", "SomeUserAgent");
    HttpEntity<String> entity = new HttpEntity<String>(headers);

    RestTemplate rt = new RestTemplate();
    String result = rt.exchange("https://cex.io/api/order_book/BTC/USD", HttpMethod.GET, entity, String.class).getBody();