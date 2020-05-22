public class Something {
    @JsonProperty("TransferRecord")
    private TransferRecord transferRecord;
    @JsonProperty("ResultCode")
    private int resultCode;
    @JsonProperty("ErrorCodes")
    private List<ErrorCode> errorCodes;
}