public interface ApiService {
String BASE_URL = "http://www.androidbegin.com/";

@GET("tutorial/jsonparsetutorial.txt")
Call<JsonResponse> getPopulationData() ;
}