import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VolleyStringRequest implements Response.Listener<String> {
    ResponseListener listener;
    Response.ErrorListener errorListener;
    int method = -1;
    String url;
    List<Header> headers = new ArrayList<>();
    Map<String, String> params;

    @Override
    public void onResponse(String response) {
        if (listener != null) {
            listener.onResponse(response, headers);
        }
    }

    public VolleyStringRequest(int method, String url, ResponseListener listener, Response.ErrorListener errorListener, Map<String, String> params) {
        this.listener = listener;
        this.method = method;
        this.url = url;
        this.errorListener = errorListener;
        this.params = params;

    }

    public VolleyStringRequest(String url, ResponseListener listener, Response.ErrorListener errorListener, Map<String, String> params) {
        this.listener = listener;
        this.url = url;
        this.errorListener = errorListener;
        this.params = params;
    }

    public Request getRequest() {
        if (method == -1) {
            return new Request(url, this, errorListener);
        } else {
            return new Request(method, url, this, errorListener);
        }
    }

    class Request extends StringRequest {

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            return params;
        }

        public Request(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(method, url, listener, errorListener);
        }

        public Request(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(url, listener, errorListener);
        }

        @Override
        protected Response<String> parseNetworkResponse(NetworkResponse response) {
            headers.addAll(response.allHeaders);
            return super.parseNetworkResponse(response);
        }
    }

    public interface ResponseListener {
        void onResponse(String response, List<Header> headers);
    }

}