public RegisterRequest(String username, String password,String isAdmin, 
        Response.Listener<String> listener,
        Response.ErrorListener() errListener){ //add error listener

   super(Method.POST, REGISTER_REQUEST_URL,listener,errListener);
   ......

 }