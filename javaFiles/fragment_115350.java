public class Response {

    @SerializedName("results")
    private ArrayList<Result> list;

    public ArrayList<Result> getList() {
        return list;
    }
}