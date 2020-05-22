@Test
void t() throws JsonProcessingException {
    C c = new C();
    String s = objectMapper.writeValueAsString(c);
    System.out.println(s);
}

public static class C {

    private boolean isActive = true;

    @JsonProperty("is_active")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}