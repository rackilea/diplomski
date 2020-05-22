public class SendData {

private Context context;
private String url;
private HashMap<String, String> data;

private OnDataSent onDataSent;

public void setOnDataSent(OnDataSent onDataSent) {
    this.onDataSent = onDataSent;
}

public SendData(Context context, String url, HashMap<String, String> data) {
    this.context = context;
    this.url = url;
    this.data = data;
}

public void send(){
    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            if(onDataSent != null){
                onDataSent.onSuccess(response);
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            if(onDataSent != null){
                onDataSent.onFailed(error.toString());
            }
        }
    }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> map = new HashMap<>();
            map.putAll(data);
            return map;
        }

    };
    stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, 0, 0));
    RequestQueue requestQueue =  Volley.newRequestQueue(context);
    requestQueue.add(stringRequest);
}

public interface OnDataSent{
    void onSuccess(String response);
    void onFailed(String error);
}