String url = "http://test.com/solarSystem/planets/{planet}/moons/{moon}";

// URI (URL) parameters
Map<String, String> urlParams = new HashMap<>();
urlParams.put("planets", "Mars");
urlParams.put("moons", "Phobos");

// Query parameters
UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
        // Add query parameter
        .queryParam("firstName", "Mark")
        .queryParam("lastName", "Watney");

System.out.println(builder.buildAndExpand(urlParams).toUri());
/**
 * Console output:
 * http://test.com/solarSystem/planets/Mars/moons/Phobos?firstName=Mark&lastName=Watney
 */

restTemplate.exchange(builder.buildAndExpand(urlParams).toUri() , HttpMethod.PUT,
        requestEntity, class_p);

/**
 * Log entry:
 * org.springframework.web.client.RestTemplate Created PUT request for "http://test.com/solarSystem/planets/Mars/moons/Phobos?firstName=Mark&lastName=Watney"
 */