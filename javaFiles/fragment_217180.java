static class Computer {
    private String ip;

    @JsonProperty("L2CacheSize")
    private Integer L2CacheSize;

    @JsonProperty("L2CacheSpeed")
    private Integer L2CacheSpeed;

    public Computer(String ip, Integer L2CacheSize, Integer L2CacheSpeed) {
        this.ip = ip;
        this.L2CacheSize = L2CacheSize;
        this.L2CacheSpeed = L2CacheSpeed;
    }

    //Getters and Setters...

}