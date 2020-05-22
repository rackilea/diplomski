public static final String TAG = DoctorHome.class.getSimpleName();
ArrayList<DoctorsCatPojo> doctorCatList = new ArrayList<>();
DoctorsCatAdapter doctorsCatAdapter;
RecyclerView recyclerView;



 private void getDoctorCategory() {
    pDialog = new ProgressDialog(this);
    pDialog.setMessage("Loading...");
    pDialog.show();
    String url = Constant.DOCTOR_CATEGORY;
    Log.e("URL",""+url);

    JsonObjectRequest request = new JsonObjectRequest(url, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.e("onResponse",""+response);
                    try {
                        status = response.getString("status");
                        if(status.equals("success")){
                            String info = response.getString("list");
                            JSONArray jsonArray = new JSONArray(info);

                            Gson gson = new Gson();
                            Type listType = new TypeToken<ArrayList<DoctorsCatPojo>>() {
                            }.getType();
                            doctorCatList = gson.fromJson(jsonArray.toString(), listType);

                            if(doctorCatList!=null && doctorCatList.size()!=0){
                                doctorsCatAdapter = new DoctorsCatAdapter(DoctorHome.this,doctorCatList);
                                recyclerView.setAdapter(doctorsCatAdapter);
                                Log.d(TAG, response.toString());
                            }


                        }
                        else {
                            message = response.getString("message");
                            // Toast.makeText(getApplicationContext(),""+message,Toast.LENGTH_SHORT).show();
                            pDialog.hide();
                        }



                    } catch (Exception e) {
                        Log.e("Exception",""+e);
                        e.printStackTrace();
                    }
                    pDialog.hide();




                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            Log.e("error",""+error.getMessage());
            pDialog.hide();
        }
    });
    AppController.getInstance(DoctorHome.this).addToRequestQueue(request, "doctor_category");


}