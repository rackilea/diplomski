enum Status {

    CLASS_NOT_FOUND_EXCEPTION("CLASS_NOT_FOUND_EXCEPTION", 2),
    ILLEGAL_ACCESS_EXCEPTION("ILLEGAL_ACCESS_EXCEPTION", 3),
    INSTANTIATION_EXCEPTION("INSTANTIATION_EXCEPTION", 4),
    MALFORMED_URL_EXCEPTION("MALFORMED_URL_EXCEPTION", 5),
    IO_EXCEPTION("IO_EXCEPTION", 6),
    INVALID_ACTION("INVALID_ACTION", 7),
    JSON_EXCEPTION("JSON_EXCEPTION", 8),
    ERROR("ERROR", 9);

    private String title;
    private int number;

    private Status(String title, int number) {
        this.title = title;
        this.number = number;
    }

    // getters
}