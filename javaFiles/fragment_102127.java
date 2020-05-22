// you do not need callback parameter here
 public interface MyRetrofit {

@POST("fc.php")
Call<Language> getLanguage(@Body JsonObject json);
  }