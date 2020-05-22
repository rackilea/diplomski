private void loadJSON(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            for (int i=2; i<jsonObject.length()+2;i++){
                                String value =jsonObject.getString(String.valueOf(i));
                                if (value.length()!=0) {
                                    ListItem item = new ListItem(value, mParam1+"/"+value, "nothing");
                                    listItems.add(item);
                                }
                            }
                            adapter = new PhotoLibraryAdapter(Photos.this,listItems,photosList,true);
                            photosList.setAdapter(adapter);
                            progressBar.setVisibility(View.GONE);
                        } catch (Exception e) {progressBar.setVisibility(View.GONE);}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }