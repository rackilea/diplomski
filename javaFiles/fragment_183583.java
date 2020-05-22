import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;

import java.net.URL;

public class JsonApiGlideUrl extends GlideUrl {

    public JsonApiGlideUrl(URL url) {
        super(url);
    }

    public JsonApiGlideUrl(String url) {
        super(url);
    }

    public JsonApiGlideUrl(URL url, Headers headers) {
        super(url, headers);
    }

    public JsonApiGlideUrl(String url, Headers headers) {
        super(url, headers);
    }

}