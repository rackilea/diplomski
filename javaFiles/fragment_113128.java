public interface Image_upload{
    @Headers({"Content-Type: image/jpg"})
    @PUT()
    Call<Void> aws_upload(@Url(value = "url", encoded = true) String path,
                          @Body RequestBody image);
}