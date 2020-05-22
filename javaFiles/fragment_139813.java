public static class Entity {

    private Integer entityNumber;

    @JsonProperty("user_number")
    private Integer userNumber;

    public Integer getEntityNumber() {
        return entityNumber;
    }
    public void setEntityNumber(Integer entityNumber) {
        this.entityNumber = entityNumber;
    }
    public Integer getUserNumber() {
        return userNumber;
    }
    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
        setEntityNumber(userNumber);
    }
}