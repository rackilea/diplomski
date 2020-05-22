class Channel {
    private long id;

    @JsonDeserialize(using = CustomDeserializer.class)
    private String roles;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}