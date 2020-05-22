String CONTENT_IMAGE = "image/jpeg";

    File file = new File(localPhotoPath);    // create new file on device
    RequestBody requestFile = RequestBody.create(MediaType.parse(CONTENT_IMAGE), file);

    /* since the pre-signed URL from S3 contains a host, this dummy URL will
     * be replaced completely by the pre-signed URL.  (I'm using baseURl(String) here
     * but see baseUrl(okhttp3.HttpUrl) in Javadoc for how base URLs are handled
     */
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://www.dummy.com/")
        .build();

    UpdateImageInterface imageInterface = retrofit.create(UpdateImageInterface.class);
    // imageUrl is the String as received from AWS S3
    Call<Void> call = imageInterface.updateImage(imageUrl, requestFile);