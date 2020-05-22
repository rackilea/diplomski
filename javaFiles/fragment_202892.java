import org.springframework.http.HttpStatus;

public int postJson(Set<String> data) {
    int statusCode;
    try {
        ResponseEntity<String> result = restTemplate.postForEntity(url,new HttpEntity<>(request, getHttpHeaders()), String.class);
        statusCode = result.getStatusCodeValue();
    } catch (Exception e) {
        LOGGER.error("No Post", e);
    }
    return statusCode;
}