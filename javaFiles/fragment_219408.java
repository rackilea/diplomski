import android.util.Log;
import android.support.annotation.Nullable;

import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

class VolleyJsonRequest {
    private ResponseListener listener;
    private int method;
    private String url;
    private List<Header> headers = new ArrayList<>();
    private JSONObject body;
    private int statusCode;

    private static final String TAG = VolleyJsonRequest.class.getSimpleName();

    public VolleyJsonRequest(int method, String url, JSONObject body, ResponseListener listener) {
        this.listener = listener;
        this.method = method;
        this.url = url;
        this.body = body;

    }

    public Request get() {
        return new Request(method, url, body.toString(), responseListener, errorListener);
    }

    Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            deliverResult(response);
        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            statusCode = error.networkResponse.statusCode;
            headers.addAll(error.networkResponse.allHeaders);
            String json;
            try {
                json = new String(
                        error.networkResponse.data,
                        HttpHeaderParser.parseCharset(error.networkResponse.headers));
                deliverResult(json);
            } catch (
                    UnsupportedEncodingException e) {
                Log.e(TAG, Log.getStackTraceString(e));
            }
        }
    };


    private void deliverResult(String response) {
        try {
            Object object = new JSONTokener(response).nextValue();
            if (object instanceof JSONObject) {
                listener.onResponse(statusCode, headers, (JSONObject) object, null);
            } else {
                listener.onResponse(statusCode, headers, null, (JSONArray) object);
            }
        } catch (JSONException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }


    class Request extends JsonRequest {

        public Request(int method, String url, @Nullable String requestBody, Response.Listener listener, @Nullable Response.ErrorListener errorListener) {
            super(method, url, requestBody, listener, errorListener);
        }

        @Override
        protected Response parseNetworkResponse(NetworkResponse response) {
            headers.addAll(response.allHeaders);
            statusCode = response.statusCode;
            String string;
            try {
                string = new String(
                        response.data,
                        HttpHeaderParser.parseCharset(response.headers));
            } catch (
                    UnsupportedEncodingException e) {
                return Response.error(new ParseError(e));
            }

            return Response.success(
                    string,
                    HttpHeaderParser.parseCacheHeaders(response));

        }
    }

    public interface ResponseListener {
        void onResponse(int statusCode, List<Header> headers, JSONObject object, JSONArray array);
    }

}