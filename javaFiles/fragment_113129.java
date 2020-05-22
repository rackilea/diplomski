Call<Object> pre_call=image_pre.upload(token,jsonObject);
pre_call.enqueue(new Callback<Object>(){
@Override
public void onResponse(Call<Object> call, Response<Object> pre_upload_response) {
       if(pre_upload_response.code() == 200) {
          // get url from json response 
          LinkedTreeMap pre_upload_url_res = (LinkedTreeMap) pre_upload_response.body();
          String image_get_url = ((LinkedTreeMap) 
           pre_upload_url_res.get("response")).get("getUrl").toString();
          //Call another API with presigned url and request body
          Retrofit retro_image_upload = new Retrofit.Builder()
                                 .baseUrl("https://www.Dummy-URL.com")
                                 .addConverterFactory(GsonConverterFactory.create())
                                 .build();
         Image_upload final_upload = retro_image_upload.create(Image_upload.class);
         Call<Void> image_upload_call = final_upload.aws_upload(image_get_url,requestBody);
         image_upload_call.enqueue(new Callback<Void>() {
           @Override
          public void onResponse(Call<Void> call, Response<Void> image_response) {
             if (image_response.code() == 200) {
                  //Do something
                }
            }
         public void onFailure(Call<Object> call, Throwable t) {
             Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_SHORT).show();}
});         

}
else{
//do something may be toast notification.
}
}
@Override
public void onFailure(Call<Void> call, Throwable t) {                                        
        Toast.makeText(getApplicationContext(), "Something went Worng", 
        Toast.LENGTH_SHORT).show();
}
});