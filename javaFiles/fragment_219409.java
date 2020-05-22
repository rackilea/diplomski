import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements VolleyJsonRequest.ResponseListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RequestQueue queue;

    String requestBody = "{\n" +
            "  \"items\": [\n" +
            "    {\n" +
            "      \"id\": \"string\",\n" +
            "      \"domain\": \"string\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"skipCrossSell\": true\n" +
            "}";
    String url = "https://www.secureserver.net/api/v1/cart/508688?redirect=false";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        testOne();
        testTwo();
    }

    private void testOne(){
        JsonRequest request = new JsonRequest(Request.Method.POST, url, requestBody, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                Log.e(TAG,"Response " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                try {
                    String response = new String(
                            error.networkResponse.data,
                            HttpHeaderParser.parseCharset(error.networkResponse.headers));

                    Log.e(TAG,error.networkResponse.allHeaders.toString());
                    Log.e(TAG,response);

                } catch (UnsupportedEncodingException e) {
                    Log.e(TAG,e.getMessage());
                }
            }
        }) {
            @Override
            protected Response parseNetworkResponse(NetworkResponse response) {
                try {


                    List<Header> headers = response.allHeaders;
                    for(Header header: headers){
                        Log.e(TAG,"Name " + header.getName() + " Value " + header.getValue());
                    }

                    String json = new String(
                            response.data,
                            HttpHeaderParser.parseCharset(response.headers));
                    return Response.success(
                            new JSONObject(json),
                            HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException e) {
                    return Response.error(new ParseError(e));
                }
            }
        };

        queue.add(request);
    }

    private  void testTwo(){

        VolleyJsonRequest jsonRequest = null;
        try {
            jsonRequest = new VolleyJsonRequest(Request.Method.POST,url, new JSONObject(requestBody),this);
            queue.add(jsonRequest.get());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onResponse(int statusCode, List<Header> headers, JSONObject object, JSONArray array) {


        Log.e(TAG,"-------------------------------");

        for(Header header: headers){
            Log.e(TAG,"Name " + header.getName() + " Value " + header.getValue());
        }


        if (object != null){
            // handle your json object
        }else if (array != null){
            // handle your json array
        }
    }
}