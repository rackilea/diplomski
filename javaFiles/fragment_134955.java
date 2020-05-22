public enum Status {
    DELETE_SUCCESS("Success", "200", "True", "Record deleted successfully"),
    DELETE_FAIL("Fail", "200", "False", ""),
    DEACTIVATE_SUCCESS("Success", "200", "True", "Record deactivated successfully"),
    DEACTIVATE_FAIL("Fail", "200", "False", ""),
    ERROR("Fail", "500", "False", "");

    private String status;
    private String statusCode;
    private String result;
    private String reason;

    Status(String status, String statusCode, String result, String reason) {
        this.status = status;
        this.statusCode = statusCode;
        this.result = result;
        this.reason = reason;
    }

    // Getters 
}