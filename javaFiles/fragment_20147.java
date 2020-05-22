public class DataResponse<T, R> {

    public T data;

    @SerializedName("meta")
    public R metadata;
}