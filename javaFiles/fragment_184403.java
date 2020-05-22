RequestQueue queue = Volley.newRequestQueue(context);
queue.getCache().clear();
StringRequest myReq = new StringRequest(Request.Method.POST,
        VolleyConnector.url,
        createMyReqSuccessListener(),
        createMyReqErrorListener()) {

    protected Map<String, String> getParams() throws com.android.volley.AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Cn","1");
        params.put("Yr","1396");
        params.put("MaxInPage","10");
        params.put("Method","Control_Vaziat_View");
        params.put("Pg","1");
        return params;
    };
};
myReq.setShouldCache(false);
queue.add(myReq);