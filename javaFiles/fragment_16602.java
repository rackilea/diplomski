public Message getMessageMedia(File file,String type) {
       Message messageObj = new Message();
       try {
           OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(180, TimeUnit.SECONDS).readTimeout(180, TimeUnit.SECONDS).build();
           RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                   .addFormDataPart(RequestParameters.USERID, "" + SharedPreferencesMethod.getUserId(this))
                   .addFormDataPart(RequestParameters.TO_USERID, "" + user.getUserId())
                   .addFormDataPart(RequestParameters.MESSAGE_MEDIA,file.getName(),RequestBody.create(MediaType.parse("application/pdf"),file))
                   .addFormDataPart(RequestParameters.MESSAGE_MEDIA_TYPE, "" + type)
                   .addFormDataPart(RequestParameters.MESSAGE,"" +"PDF")
                   .addFormDataPart("msg_identifer", System.currentTimeMillis() + "")
                   .build();
           Request request = new Request.Builder()
                   .url(API.SEND_MESSAGE)
                   .post(body)
                   .build();
           System.out.println("Input Data"+request.toString());
           client.newCall(request).enqueue(new Callback() {
               @Override
               public void onFailure(final Call call, final IOException e) {
                   System.out.println("PDF Faliure   "+e.toString());
               }
               @Override
               public void onResponse(final Call call, final Response response) throws IOException {
                   if (!response.isSuccessful()) {
                       System.out.println("PDF Response Error   "+response.toString());
                   }else{
                       System.out.println("PDF Response   "+response.toString());
                   }
               }
           });
           etMessage.setText("PDF");
           Date now = Calendar.getInstance().getTime();
           SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
           messageObj.setId(REMOVE);
           messageObj.setMsg_identifer(System.currentTimeMillis() + "");
           messageObj.setMessageMedia(String.valueOf(file));
           messageObj.setMessageMediaType(type);
           messageObj.setReadStatus("0");
           messageObj.setMessageAT("Sending...");
           messageObj.setUserId(SharedPreferencesMethod.getUserId(getApplicationContext()));
       } catch (Exception ex) {
           System.out.println("Media Message Error  "+ex);
       }
       return messageObj;
   }