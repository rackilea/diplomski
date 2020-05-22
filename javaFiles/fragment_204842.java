// code..
               @Override
                public void onResponse(JSONObject response) {

                    Gson gson = new Gson();
                    try { 
                        UserModel user= gson.fromJson(response.getJSONObject("customer").toString(), UserModel.class);
                        Hawk.put("user", user); // here I save the user object
                        Toasty.success(context, "Login was a success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(context, MyHome.class);
                        context.startActivity(i);

                    } catch (JSONException e) {
                        e.printStackTrace();       
                    }
                }
               // code..