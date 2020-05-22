insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String DESCR = Descr.getText().toString();
                final String Spin = staticSpinner.getSelectedItem().toString();

                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override


                    public void onResponse(String response) {
                        if(Descr.getText().toString().equals("")){
                            Toast.makeText(getApplication(),"Please Enter Detail ",Toast.LENGTH_LONG).show();
                        }
                        else if(Descr.getText().toString().length()<10){
                            Toast.makeText(getApplication(),"Text Must be Greater Than 10",Toast.LENGTH_LONG).show();
                        }
                        else{
                            System.out.println(response.toString());
                            Toast.makeText(getApplication(),"Application Submitted Successfully....!",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(atd_leave_form. this, Issue.class);
                            startActivity(intent);

                        }
                    }}, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("Descr",Descr.getText().toString());
                        parameters.put("Spin",Spin);//change here
                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });


    }

}