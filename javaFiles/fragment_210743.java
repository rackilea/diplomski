// Call your volley request.
mVolleySingleton = VolleySingleton.getInstance();

//intitalize Volley Singleton request key
mRequestQueue = mVolleySingleton.getRequestQueue();

//2 types of requests an Array request and an Object Request
JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL_API, (String) null, new Response.Listener<JSONArray>() {
    @Override
    public void onResponse(JSONArray response) {
        // Create AsyncTask.
        MyTask parseJSONTask = new MyTask();

        // Set listener interface.
        parseJSONTask.setOnJSONParsedListener(new MyTask.OnJSONParsedListener() {
            @Override
            public void onJSONParsed(ArrayList<Blogs> blogsList) {
                // Do stuff with your blogs list.
                mAdapterDashBoard.setBloglist(blogsList);

                // It worked!
                System.out.println("it worked!!!");
            }
        }

        // Execute.
        parseJSONTask.execute(response);
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
    }
});
mRequestQueue.add(request);