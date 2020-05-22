import com.google.gson.annotations.SerializedName;

class DataMetrics {

    [..]

    private Dimensions dimensions;

    private class Dimensions{
        private String env;
        private String pool;
        @SerializedName("Name")
        private String nameYouWant;
    }
}