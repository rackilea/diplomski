public enum Status {
    @JsonProperty("ready")
    READY,
    @JsonProperty("notReady")
    NOT_READY,
    @JsonProperty("notReadyAtAll")
    NOT_READY_AT_ALL;
}