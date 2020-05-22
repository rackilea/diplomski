enum HttpConstants {

    HTTP_OK(200), HTTP_CREATED(201), HTTP_ACCEPTED(202),
    HTTP_NOT_AUTHORITATIVE(203),HTTP_NO_CONTENT(204), 
    HTTP_RESET(205), HTTP_PARTIAL(206) /* ... */;

    private int value;

    HttpConstants(int aValue) {
        value=aValue;
    }

    public int getValue() {
        return value;
    }
}