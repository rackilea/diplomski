String json="{\"Health\":{\"id\":\"abc_Server\",\"name\":\"ABCRequestService\",\"status\":\"GREEN\",\"dependencies\":[{\"id\":\"DB\",\"name\":\"MySQL\",\"message\":\"Connectionsuccessful.\",\"status\":\"GREEN\"}]}}";

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
    try {
        HealthResponse healthResponse = objectMapper.readValue(json, HealthResponse.class);
        System.out.println(healthResponse.getId());
    } catch (Exception e) {
        e.printStackTrace();
    }