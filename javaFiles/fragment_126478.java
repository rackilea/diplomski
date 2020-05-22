public interface ContentInterface
{
    @GET("/public/content/{category}")
    ContentResponse<String> getContent(@Path(PathParameters.CATEGORY) String category);

    ContentResponse<Map<String, String> getContent(@Path(PathParameters.CATEGORY) String category);
}