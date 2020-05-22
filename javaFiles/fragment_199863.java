if( etUsername.getText().toString().matches("") || etPassword.getText().toString().matches("")  || etPassword2.getText().toString().matches("")  )
 {
 Toast.makeText(getApplicationContext(),"Please enter all fields....",Toast.LENGTH_SHORT).show();
 }
 else if( ! etPassword.getText().toString().matches(etPassword2.getText().toString()))
 {
 Toast.makeText(getApplicationContext(),"Please enter same both password fields....",Toast.LENGTH_SHORT).show();
 }

  else
  {
        Response.Listener<String> responeListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonRespone = new JSONObject(response);
                    boolean success = jsonRespone.getBoolean("success");


                        Intent intent = new Intent(RegisterActivity.this, RegisterActivity2.class);
                        RegisterActivity.this.startActivity(intent);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        RegisterRequest registerRequest = new RegisterRequest(Username, Acc_Pass, Acc_Pass2, responeListener);
        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
        queue.add(registerRequest);

    }
   }