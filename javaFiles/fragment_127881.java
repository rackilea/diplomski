@PrePersist
public void prePersist() {
    try {
        this.setJsonData(new ObjectMapper().writeValueAsString(this));
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
}