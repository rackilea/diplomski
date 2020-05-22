public interface ContentInterface
{
    @GET("/public/content/{category}")
    ContentResponse<String> getContentAsString(@Path(PathParameters.CATEGORY) String category);

    ContentResponse<Map<String, String> getContentAsMap(@Path(PathParameters.CATEGORY) String category);
}