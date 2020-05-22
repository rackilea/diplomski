import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class JsonApiDataModel {

    @SerializedName("media_details")
    MediaDetails mediaDetails;

    public static String getSourceUrl(String json) {
        return new Gson().fromJson(json, JsonApiDataModel.class).mediaDetails.sizes.full.sourceUrl;
    }

    public class MediaDetails {
        @SerializedName("sizes")
        Sizes sizes;
    }

    public class Sizes {
        // you can use full, medium or thumbnail here!
        @SerializedName("full")
        Full full;
    }

    public class Full {
        @SerializedName("source_url")
        String sourceUrl;
    }

}