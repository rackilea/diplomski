private void doLogin(final String mobile){
      try {
           JsonObject paramObject = new JsonObject();
           paramObject.addProperty("mobile", mobile);
        } catch (JSONException e) {
            e.printStackTrace();
        }

      Call<ResObj> call = userService.login(paramObject);
      call.enqueue(new Callback<ResObj>() {

        //your rest of code

      });
}