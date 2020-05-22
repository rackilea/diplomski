public class JsonResult {
    private String status;
    private Meta meta;
    @SerializedName("data")
    private ArrayList<Player> players;
}