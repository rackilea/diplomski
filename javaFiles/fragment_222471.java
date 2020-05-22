String json = "{\"invoices\":{\"createDate\":{\"operation\":\"betweenDate\",\"options\":[{\"name\":\"startDate\",\"value\":[\"06/01/2016\"]},{\"name\":\"endDate\",\"value\":[\"06/02/2016\"]}]}}}";

RestTemplate restTemplate = new RestTemplate();

URI targetUrl = UriComponentsBuilder
        .fromUriString("https://api.softlayer.com")
        .path("rest")
        .path("v3")
        .path("SoftLayer_Account")
        .path("getInvoices")
        .queryParam("objectFilter", 
            URLEncoder.encode(json, StandardCharsets.UTF_8.toString()))
        .build()
        .toUri();

String result = restTemplate.getForObject(targetUrl, String.class);