public static  class StreamServer {
    @JsonProperty("value")
    private String value;

    @JsonProperty("list")
    private List<Server> serverList;

}

public static class Server {
    @JsonProperty("id")
    private String id;

    @JsonProperty("desc")
    private String desc;
}