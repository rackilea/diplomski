public enum Status {
    READY("ready"),
    NOT_READY("notReady"),
    NOT_READY_AT_ALL("notReadyAtAll");

    private static Map<String, Status> FORMAT_MAP = Stream
        .of(Status.values())
        .collect(Collectors.toMap(s -> s.formatted, Function.identity()));

    private final String formatted;

    Status(String formatted) {
        this.formatted = formatted;
    }

    @JsonCreator // This is the factory method and must be static
    public static Status fromString(String string) {
        return Optional
            .ofNullable(FORMAT_MAP.get(string))
            .orElseThrow(() -> new IllegalArgumentException(string));
    }
}