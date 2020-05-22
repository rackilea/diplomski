public void buildDetailsFromJson(String details) {
    if (details != null) {        
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.enable(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
            // assuming the eventDetails is an instance of DetailsData
            eventDetails = mapper.readValue(details, DetailsData.class);
        } catch (IOException e) {
            log.error("Exception during JSON {} parsing! {}", details, e.getMessage());
        }
    }
}