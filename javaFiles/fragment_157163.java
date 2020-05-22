public final void getClientes(final ClientesRestListener listener) {
    String url = this.URL_WS + recursoRest;
    mRequestQueue = Volley.newRequestQueue(this.context);
    JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                List<ClienteModel> clientes = parseJSON(response);
                listener.clientesReceived(clientes);
            }
        }, /* Error listener here*/) {/* add headers here */};
    mRequestQueue.add(mJsonObjectRequest);
}