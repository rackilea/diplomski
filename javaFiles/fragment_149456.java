public class WrapperResponse<T> {
    @SerializedName(value="higher_level", alternate={"mid_level", "other"})
    @Expose
    DataResponse<T> data;

    public DataResponse<T> getData() {
        return data;
    }

    public void setData(DataResponse<T> data) {
        this.data = data;
    }
}