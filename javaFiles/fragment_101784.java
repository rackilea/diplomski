String url = "myUrl";
    RequestQueue queue = Volley.newRequestQueue(getContext());
    schoolContributeList = new ArrayList<>();
    JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.POST, url+"?schoolUniversity="+selectedUniversityItem.getmUniversityValue()+"&key="+key,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray ja) {
                    try {
                        for (int i = 0;i < ja.length();i++) {
                            JSONObject school = ja.getJSONObject(i);

                            String schoolId = school.getString("id");
                            String schoolName = school.getString("name");
                            universityItem schoolItem = new universityItem(schoolName, schoolId);

                            Toast.makeText(getContext(),schoolId , Toast.LENGTH_SHORT).show();
                            schoolContributeList.add(schoolItem);
                            schoolContributeAdapter =  new universityAdapter(getContext(), schoolContributeList);
                            schoolContributeSpinner.setAdapter(schoolContributeAdapter);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) 
        {
            Log.i("error", error.toString());
            Toast.makeText(getContext(), "no response", Toast.LENGTH_SHORT).show();
        }
    }){


    };
    queue.add(jsonRequest);