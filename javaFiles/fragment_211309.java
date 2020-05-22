public class OrderResponse {
    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private OrderListModel data;

    ...