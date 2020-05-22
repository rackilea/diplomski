import android.support.annotation.NonNull;
import android.util.Log;

import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Fetches an {@link InputStream} using the okhttp library.
 */
public class OkHttpJsonApiFetcher implements okhttp3.Callback {

    private static final String TAG = "OkHttpJsonApiFetcher";
    private final Call.Factory client;
    private final JsonApiGlideUrl url;
    private ResponseBody responseBody;
    private DataFetcher.DataCallback<? super GlideUrl> callback;
    // call may be accessed on the main thread while the object is in use on other threads. All other
    // accesses to variables may occur on different threads, but only one at a time.
    private volatile Call call;

    // Public API.
    @SuppressWarnings("WeakerAccess")
    public OkHttpJsonApiFetcher(Call.Factory client, JsonApiGlideUrl url) {
        this.client = client;
        this.url = url;
    }

    public void loadData(@NonNull final DataFetcher.DataCallback<? super GlideUrl> callback) {
        Request.Builder requestBuilder = new Request.Builder().get().url(url.toStringUrl());
        for (Map.Entry<String, String> headerEntry : url.getHeaders().entrySet()) {
            String key = headerEntry.getKey();
            requestBuilder.addHeader(key, headerEntry.getValue());
        }
        Request request = requestBuilder.build();
        this.callback = callback;

        call = client.newCall(request);
        call.enqueue(this);
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "OkHttp failed to obtain result", e);
        }
        callback.onLoadFailed(e);
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) {
        responseBody = response.body();
        if (response.isSuccessful() && responseBody != null) {
            try {
                String json = responseBody.string();
                String url = JsonApiDataModel.getSourceUrl(json);
                callback.onDataReady(new GlideUrl(url));
            } catch (IOException e) {
                callback.onLoadFailed(new HttpException(response.message(), response.code()));
                e.printStackTrace();
            }
        } else {
            callback.onLoadFailed(new HttpException(response.message(), response.code()));
        }
    }

    public void cleanup() {
        if (responseBody != null) {
            responseBody.close();
        }
        callback = null;
    }

    public void cancel() {
        Call local = call;
        if (local != null) {
            local.cancel();
        }
    }

}