public interface ArticleGetListService {
    @FormUrlEncoded // Request will have "application/x-www-form-urlencoded"  MIME type
    @POST("/api/Article/ArticleGetList")
    public void getArticleList(@Field("LanguageCode") String languageCode,
                               @Field("CategoryId") String categoryId,
                               @Field("Token") String token,
                               Callback<ArticleViewPojo> response); //POJO: The json retrieved from the server is added to this class.
}