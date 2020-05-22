public void setJsonData(String jsonData) {
    // Method parameter jsonData is simply ignored
    try {
        this.jsonData = new ObjectMapper().writeValueAsString(this);
    } catch (JsonProcessingException e) {
        log.error(e.getMessage());
    }
}