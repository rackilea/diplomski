enum Error {

    ERROR_000("000", 1, "No error"),
    ERROR_001("001", 1, "Connection error"),
    ERROR_002("002", 1, "Error sending reversal or batch capture process"),
    ERROR_003("003", 1, "Error after authorization – message sent" +
                        "to host and answer received"),
    ERROR_004("004", 1, "Error sending message for authorization"),
    ERROR_005("005", 1, "Error receiving message from host");

    private final String code;
    private final int position;
    private final String description;
    private static final Map<String, Error> errorMap =
        new HashMap<String, Error>();

    static {
        for (Error error : Error.values()) {
            errorMap.put(error.code, error);
        }
    }

    Error(final String code, final int position, final String description) {
        this.code = code;
        this.position = position;
        this.description = description;
    }

    public static Error getError(String code) {
        return errorMap.get(code);
    }
    // add getters and setters here:
    public String getCode() { return this.code; }
    public int getPosition() { return this.position; }
    public String getDescription() { return this.description; }
}