public enum Status {

    New(1), Rejected(2), Cancelled(5);

    private int code;

    private Status(int code) {
        this.code = code;
    }

    public static Status of(int code) {
        for (Status status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException();
    }

    public int getCode() { 
        return code;
    }

}