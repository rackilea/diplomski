public interface CardsService {

    String BASE_URL = "http://yourbaseurl.api/";

    @GET("endpoint")
    Call<MainCard> getCards();

}