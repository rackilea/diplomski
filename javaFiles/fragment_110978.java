@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 100 && resultCode == RESULT_OK && data != null) {

        //getting the image Uri
        Uri imageUri = data.getData();
        try {
            //getting bitmap object from uri
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);

            //displaying selected image to imageview
            logo.setImageBitmap(bitmap);

            //calling the method uploadBitmap to upload image
            loading.setVisibility(View.VISIBLE);
            ///uploadBitmap(bitmap);

            File file = new File(getRealPathFromUri(this, imageUri));
            uploadImageFile(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public static String getRealPathFromUri(Context context, Uri contentUri) {
    Cursor cursor = null;
    try {
        String[] proj = { MediaStore.Images.Media.DATA };
        cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    } finally {
        if (cursor != null) {
            cursor.close();
        }
    }
}

private void uploadImageFile(File file) throws IOException {

    file  = new Compressor(this).compressToFile(file);
    RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
    // MultipartBody.Part is used to send also the actual filename
    MultipartBody.Part body = MultipartBody.Part.createFormData("avatar", file.getName(), requestFile);

    ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);
    Call<ServerResponse> call = getResponse.uploadFile("Bearer "+jsonToken, body);
    call.enqueue(new Callback< ServerResponse >() {
        @Override
        public void onResponse(@NonNull Call < ServerResponse > call, @NonNull retrofit2.Response<ServerResponse> response) {
            ServerResponse serverResponse = response.body();

            if (serverResponse.getData() != null) {
                Log.e(TAG, "Response is "+ serverResponse.getData());
               loading.setVisibility(View.GONE);
                Toast.makeText(ProfileSettings.this, "Avatar updated", Toast.LENGTH_SHORT).show();
            } else {
                Log.e("Response", String.valueOf(serverResponse));
            }
        }


        @Override
        public void onFailure(Call < ServerResponse > call, Throwable t) {
            Log.e(TAG, t.getMessage());
        }
    });
       // Log.e(TAG, "request is "+call.request().body()+" and "+call.request().headers());
    }